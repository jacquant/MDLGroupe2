package be.unamur.mdl_groupe2.root.api.user;

import be.unamur.mdl_groupe2.root.models.user.User;
import be.unamur.mdl_groupe2.root.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Strings;
import org.apache.commons.io.IOUtils;
import org.json.*;

import be.unamur.mdl_groupe2.root.models.response.*;
import be.unamur.mdl_groupe2.root.models.user.*;

import static be.unamur.mdl_groupe2.root.models.response.OperationResponse.*;


@RestController
@Api(tags = {"Authentication"})
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Gets current user information", response = UserResponse.class)
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = {"application/json"})
    public UserResponse getUserInformation(@RequestParam(value = "name", required = false) String userIdParam, HttpServletRequest req) {

        String loggedInUserId = userService.getLoggedInUserId();

        User user;
        boolean provideUserDetails = false;

        if (Strings.isNullOrEmpty(userIdParam)) {
            provideUserDetails = true;
            user = userService.getLoggedInUser();
        } else if (loggedInUserId.equals(userIdParam)) {
            provideUserDetails = true;
            user = userService.getLoggedInUser();
        } else {
            //Check if the current user is superuser then provide the details of requested user
            provideUserDetails = true;
            user = userService.getUserInfoByUserId(userIdParam);
        }

        UserResponse resp = new UserResponse();
        if (provideUserDetails) {
            resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
        } else {
            resp.setOperationStatus(ResponseStatusEnum.NO_ACCESS);
            resp.setOperationMessage("No Access");
        }
        resp.setData(user);
        return resp;
    }


    @ApiOperation(value = "Add new user", response = OperationResponse.class)
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = {"application/json"})
    public OperationResponse addNewUser(@RequestBody User user, HttpServletRequest req) {
        boolean userAddSuccess = userService.addNewUser(user);
        OperationResponse resp = new OperationResponse();
        if (userAddSuccess == true) {
            resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
            resp.setOperationMessage("User Added");
        } else {
            resp.setOperationStatus(ResponseStatusEnum.ERROR);
            resp.setOperationMessage("Unable to add user");
        }
        return resp;
    }


}
