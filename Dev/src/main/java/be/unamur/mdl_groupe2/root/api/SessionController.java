package be.unamur.mdl_groupe2.root.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import be.unamur.mdl_groupe2.root.models.response.OperationResponse.ResponseStatusEnum;
import be.unamur.mdl_groupe2.root.models.session.SessionItem;
import be.unamur.mdl_groupe2.root.models.session.SessionResponse;
import be.unamur.mdl_groupe2.root.models.user.Login;
import be.unamur.mdl_groupe2.root.models.user.User;
import be.unamur.mdl_groupe2.root.repositories.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/*
This is a dummy rest synonyme, for the purpose of documentation (/session) path is map to a filter
 - This will only be invoked if security is disabled
 - If Security is enabled then SessionFilter.java is invoked
 - Enabling and Disabling Security is done at config/applicaton.properties 'security.ignored=/**'
*/

@RestController
@Api(tags = { "Authentication" })
@CrossOrigin(origins = { "http://localhost:8181", "http://localhost:8080" }, maxAge = 3000)
public class SessionController {

    @Autowired
    private UserRepository userRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Will return a security token, which must be passed in every request", response = SessionResponse.class) })
    @RequestMapping(value = "/session", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SessionResponse newSession(@RequestBody Login login, HttpServletRequest request,
            HttpServletResponse response) {
        User user = userRepository.findOneByUserIdAndPassword(login.getUsername(), login.getPassword()).orElse(null);
        SessionResponse resp = new SessionResponse();
        SessionItem sessionItem = new SessionItem();
        if (user != null) {
            sessionItem.setToken("xxx.xxx.xxx");
            sessionItem.setUserId(user.getUserId());
            sessionItem.setFirstName(user.getFirstName());
            sessionItem.setLastName(user.getLastName());
            sessionItem.setEmail(user.getEmail());
            // sessionItem.setRole(user.getRole());

            resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
            resp.setOperationMessage("Dummy Login Success");
            resp.setItem(sessionItem);
        } else {
            resp.setOperationStatus(ResponseStatusEnum.ERROR);
            resp.setOperationMessage("Login Failed");
        }
        return resp;
    }

}
