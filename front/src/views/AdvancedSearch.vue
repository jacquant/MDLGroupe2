<template>
    <div id="advancedSearch" width="100%">
        <v-container>
            <table  width="500px" >
              <tr>
                <td rowspan="2" >                  
                   Author:
                   <br>
                   <br>
                   <br> 
                   <br>
                   <br>
                   <br>                  
                </td>
                 <td rowspan="2">  
                    <br>
                    <br>
                    <br>
                    Not                
                </td>
                <td>                  
                   <v-flex>
                      <v-text-field
                           label="Enter Author "
                           color="success"                          
                            outline
                            v-model="authorfield1"
                      ></v-text-field>
                  </v-flex>            
                </td>
              </tr>
              <tr>
                <td>
                  <v-flex>
                      <v-text-field
                           label="Enter Author " 
                           color="success"                         
                            outline
                             v-model="authorfield2"
                      ></v-text-field>
                  </v-flex>   
                </td>             
               </tr>
              <br>
              <tr>
                <td rowspan="2">                  
                   Title:
                   <br>
                   <br>
                   <br> 
                   <br>
                   <br>
                   <br>                    
                </td>
                 <td rowspan="2"> 
                  <br>
                  <br>
                  <br>                 
                  Not                 
                </td>
                <td>                  
                   <v-flex>
                      <v-text-field
                           label="Enter title " 
                           color="success"                         
                            outline
                            v-model="titlefield1"
                      ></v-text-field>
                  </v-flex>            
                </td>
              </tr>
              <tr>
                <td>
                  <v-flex>
                      <v-text-field
                           label="Enter title "
                           color="success"                          
                            outline
                             v-model="titlefield2"
                      ></v-text-field>
                  </v-flex>   
                </td>             
               </tr>
               <br>
               <br>
               <tr>
                <td rowspan="2">                  
                   Article:
                   <br>
                   <br>
                   <br> 
                   <br>
                   <br>
                   <br>                    
                </td>
                 <td rowspan="2">
                    <br>
                    <br>
                    <br>                  
                    Not                 
                </td>
                <td>                  
                   <v-flex>
                      <v-text-field
                           label="Enter text " 
                           color="success"                         
                            outline
                            v-model="articlefield1"
                      ></v-text-field>
                  </v-flex>            
                </td>
              </tr>
              <tr>
                <td>
                  <v-flex>
                      <v-text-field
                           label="Enter text " 
                           color="success"                         
                            outline
                             v-model="articlefield2"
                      ></v-text-field>
                  </v-flex>   
                </td>             
               </tr>

               <tr><td colspan="3">
                    <v-card-actions>
                            <v-spacer></v-spacer>        
                            <v-btn color @click="Search" class="titre">Search</v-btn>
                    </v-card-actions>
              </td></tr>


            </table>
        </v-container>
    </div>
</template>

<script>
    import API from "@/api";
    import Material from "vuetify/es5/util/colors";
    import axios from "axios";
    import { setTimeout } from 'timers';
    export default {
        data: () => ({
            color: Material,
            
        }),
       
        methods: {
           
            Search() {
               
                var authorfield1=[],authorfield2=[],titlefield1=[],titlefield2=[],articlefield1=[],articlefield2=[];
                
                if (this.authorfield1 != undefined){
                    if(this.authorfield1.includes(",")) {                    
                        authorfield1=this.authorfield1.split(",") ;
                    }
                    else  
                    {
                        authorfield1=this.authorfield1.split(" ") ;
                    }
                     //alert("auteur field1 "+authorfield1.length);
                } 
                if (this.authorfield2 != undefined){
                     
                     if(this.authorfield2.includes(",")){
                        authorfield2=this.authorfield2.split(",");
                    }
                    else {
                        authorfield2=this.authorfield2.split(" ");
                        }
                    //alert("auteur field2 "+authorfield2.length);
                }
               
              
                if(this.titlefield1 != undefined){
                    if(this.titlefield1.includes(",")){
                        titlefield1=this.titlefield1.split(",");
                    }
                    else {
                        titlefield1=this.titlefield1.split(" ");
                    }
                    //alert("title field1 "+titlefield1.length);
                }
                if (this.titlefield2 != undefined){
              
                    if(this.titlefield2.includes(",")){
                        titlefield2=this.titlefield2.split(",");
                    }
                    else  {
                        titlefield2=this.titlefield2.split(" ");
                    }
                    //alert("title field2 "+titlefield2.length);
                }

             if (this.articlefield1 != undefined){

                 if(this.articlefield1.includes(",")){
                     articlefield1=this.articlefield1.split(",");
                 }
                 else {
                     articlefield1=this.articlefield1.split(" ");
                 }
                  //alert("article field1 "+articlefield1.length);
             }
              
            if (this.articlefield2 != undefined){

                 if(this.articlefield2.includes(",")){
                     articlefield2=this.articlefield2.split(",");
                 }
                 else {
                     articlefield2=this.articlefield2.split(" ");
                 }
                  //alert("article field2 "+articlefield2.length);
            }

                //console.log("tableau:"+ authorfield1,authorfield2);
            
               var map = new Map();
               var i;
               
                for ( i = 0; i < authorfield1.length; i++) {                   
                    map.set("autheur", authorfield1[i]);
                }
                for ( i = 0; i < authorfield2.length; i++) {                   
                    map.set("notautheur", authorfield2[i]);
                }

                for ( i = 0; i < titlefield1.length; i++) {                   
                    map.set("title", titlefield1[i]);
                }
                for ( i = 0; i < titlefield2.length; i++) {                   
                    map.set("nottitle", titlefield2[i]);
                }

                for ( i = 0; i < articlefield1.length; i++) {                   
                    map.set("article", articlefield1[i]);
                }
                for ( i = 0; i < articlefield2.length; i++) {                   
                    map.set("article", articlefield2[i]);
                }

   /*
                axios.get(
                    "http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/AdvancedSearch?params=",
                    {
                        params: {
                            params: map
                        }
                    })
                    .then(function(response){
                        console.log(response);
                        setTimeout(() => {
                            this.$router.push({
                                path:"/result_page",
                                query:{
                                    data: response
                                }
                            })
                        })
                    })
                    .catch(function(error){
                        console.log(error)
                    })
                    */

                   setTimeout(() => {
                            this.$router.push({
                                path:"/result_page",
                                query:{
                                    data: map
                                }
                            })
                        })
            }
        }
    };
</script>

<style scoped lang="css">
    .titre {
        color:lightslategrey;
        font-weight: bold;
    }
</style>