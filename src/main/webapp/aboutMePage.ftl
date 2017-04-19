<#import "templatePage.ftl" as page>
<#import "/spring.ftl" as spring>


<@spring.bind "userForm"/>


<@page.template>
<div class="container-fluid" style="text-align: center; font-size: larger; margin-top: 50;"
     xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">

<#--Name-->
    <div class="row">

            <div class="col-sm-2">
                <div class="thumbnail" STYLE="border: none;">
                    <strong>Name :</strong>
                </div>
            </div>

            <div class="col-sm-2"">
                <div class="thumbnail" id="name">
                    <spring.bind path="user"/>
                    ${user.name}
                </div>
             </div>

            <script>
                $(document).ready(function(){
                    var x =0;

                    $("#name").click(function(){
                        if(x==0){
                            $(".showName").attr("style", "visibility: inherit");
                            x=1;
                        }else{
                            $(".showName").attr("style", "visibility: hidden");
                            x=0;
                        }
                    });
                });
            </script>


                <div class="showName col-sm-2" style="visibility: hidden">
                    <div class="thumbnail" STYLE="border: none;">
                        <strong> Change name : </strong>
                    </div>
                </div>

                <form action="changeName"  role="form" method="post" ">
                        <div class="showName col-sm-2" style="visibility: hidden">
                            <div class="thumbnail" STYLE="border: none;">
                                <#--<input type="text" name="new name">-->
                                <@spring.formInput "userForm.name" />
                            </div>
                        </div>

                        <div class="showName col-sm-1" style="visibility: hidden">
                            <div class="thumbnail" STYLE="border: none;font-size: 20px; color: green">
                                <button type="submit" style="border: none; background-color: white;"
                                        class="glyphicon glyphicon-ok icon-large"></button>
                            </div>
                        </div>
                </form>
            <#--</div>-->

    </div>



    <#--Lastname-->
    <div class="row">

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong>Last name :</strong>
        </div>
    </div>

    <div class="col-sm-2"">
        <div class="thumbnail" id="lastName">
            <spring.bind path="user"/>
            ${user.last_name}
        </div>
    </div>

    <script>
        $(document).ready(function(){
            var x =0;

            $("#lastName").click(function(){
                if(x==0){
                    $(".showLastName").attr("style", "visibility: inherit");
                    x=1;
                }else{
                    $(".showLastName").attr("style", "visibility: hidden");
                    x=0;
                }
            });
        });
    </script>

    <div class="showLastName col-sm-2" style="visibility: hidden">
        <div class="thumbnail" style="border: none;">
            <strong> Change last name : </strong>
        </div>
    </div>
        <form action="changeLastName"  role="form" method="post" ">
            <div class="showLastName col-sm-2" style="visibility: hidden">
                <div class="thumbnail" STYLE="border: none;">
                    <@spring.formInput "userForm.last_name" />
                </div>
            </div>

            <div class="showLastName col-sm-1" style="visibility: hidden">
                <div class="thumbnail" STYLE="border: none;font-size: 20px; color: green">
                    <button type="submit" style="border: none; background-color: white;"  class="glyphicon glyphicon-ok icon-large"></button>
                </div>
            </div>
        </form>
    </div>



    <#-- ROLE-->
    <div class="row">

        <div class="col-sm-2">
            <div class="thumbnail" STYLE="border: none;">
                <strong>Role :</strong>
            </div>
        </div>

        <div class="col-sm-2" id="role">
        <div class="thumbnail">
            <spring.bind path="user"/>
        ${user.role.name}
        </div>
        </div>

    <script>
        $(document).ready(function(){
            var x =0;

            $("#role").click(function(){
                if(x==0){
                    $(".showRole").attr("style", "visibility: inherit");
                    x=1;
                }else{
                    $(".showRole").attr("style", "visibility: hidden");
                    x=0;
                }
            });
        });
    </script>

        <div class="showRole col-sm-2" style="visibility: hidden">
            <div class="thumbnail" STYLE="border: none;">
                <strong> Change role : </strong>
            </div>
        </div>

        <form action="changeRole"  role="form" method="post" ">
            <div class="showRole col-sm-2" style="visibility: hidden">
                <div class="thumbnail" STYLE="border: none;">

                            <@spring.bind path="roleList"/>
                            <div class="form-group">
                                <select class="selectpicker form-control" id="selectRole" name="selectRole">
                                    <#list roleList as role>
                                        <option>${role.name}</option>
                                    </#list>
                                </select>
                            </div>

                </div>
            </div>


            <div class="showRole col-sm-1" style="visibility: hidden">
                <div class="thumbnail" STYLE="border: none;font-size: 20px; color: green">
                    <button type="submit" style="border: none; background-color: white;"  class="glyphicon glyphicon-ok icon-large"></button>
                </div>
            </div>
        </form>
    </div>



    <#--Country-->
    <div class="row">

        <div class="col-sm-2">
            <div class="thumbnail" STYLE="border: none;">
                <strong>Country :</strong>
            </div>
        </div>

        <div class="col-sm-2" id="country">
            <div class="thumbnail">
                <spring.bind path="user"/>
            ${user.country}
            </div>
        </div>

    <script>
        $(document).ready(function(){
            var x =0;

            $("#country").click(function(){
                if(x==0){
                    $(".showCountry").attr("style", "visibility: inherit");
                    x=1;
                }else{
                    $(".showCountry").attr("style", "visibility: hidden");
                    x=0;
                }
            });
        });
    </script>

        <div class="showCountry col-sm-2" style="visibility: hidden">
            <div class="thumbnail" STYLE="border: none;">
                <strong> Change country : </strong>
            </div>
        </div>

        <form action="changeCountry"  role="form" method="post" ">
            <div class="showCountry col-sm-2" style="visibility: hidden">
                <div class="thumbnail" STYLE="border: none;">
                    <@spring.formInput "userForm.country" />
                </div>
            </div>

            <div class="showCountry col-sm-1" style="visibility: hidden">
                <div class="thumbnail" STYLE="border: none;font-size: 20px; color: green">
                    <button type="submit" style="border: none; background-color: white;"  class="glyphicon glyphicon-ok icon-large"></button>
                </div>
            </div>
        </form>
    </div>



    <#--Login-->
    <div class="row">

        <div class="col-sm-2">
            <div class="thumbnail" STYLE="border: none;">
                <strong>Login :</strong>
            </div>
        </div>

        <div class="col-sm-2" id="login">
            <div class="thumbnail">
                <spring.bind path="user"/>
            ${user.login}
            </div>
        </div>

    <script>
        $(document).ready(function(){
            var x =0;

            $("#login").click(function(){
                if(x==0){
                    $(".showLogin").attr("style", "visibility: inherit");
                    x=1;
                }else{
                    $(".showLogin").attr("style", "visibility: hidden");
                    x=0;
                }
            });
        });
    </script>

        <div class="showLogin col-sm-2" style="visibility: hidden">
            <div class="thumbnail" STYLE="border: none;">
                <strong> Change login : </strong>
            </div>
        </div>
        <form action="changeLogin"  role="form" method="post" ">
            <div class="showLogin col-sm-2" style="visibility: hidden">
                <div class="thumbnail" STYLE="border: none;">
                    <@spring.formInput "userForm.login" />
                </div>
            </div>

            <div class="showLogin col-sm-1" style="visibility: hidden">
                <div class="thumbnail" STYLE="border: none;font-size: 20px; color: green">
                    <button type="submit" style="border: none; background-color: white;"  class="glyphicon glyphicon-ok icon-large"></button>
                </div>
            </div>

        </form>
    </div>



    <#--Password-->
    <div class="row">

        <div class="col-sm-2">
            <div class="thumbnail" STYLE="border: none;">
                <strong>Password :</strong>
            </div>
        </div>

        <div class="col-sm-2" id="password">
            <div class="thumbnail">
                <spring.bind path="user"/>
            ${user.password}
            </div>
        </div>

    <script>
        $(document).ready(function(){
            var x =0;

            $("#password").click(function(){
                if(x==0){
                    $(".showPassword").attr("style", "visibility: inherit");
                    x=1;
                }else{
                    $(".showPassword").attr("style", "visibility: hidden");
                    x=0;
                }
            });
        });
    </script>

        <div class="showPassword col-sm-2" style="visibility: hidden">
            <div class="thumbnail" STYLE="border: none;">
                <strong> Change password : </strong>
            </div>
        </div>
        <form action="changePassword"  role="form" method="post" ">
            <div class="showPassword col-sm-2" style="visibility: hidden">
                <div class="thumbnail" STYLE="border: none;">
                    <@spring.formInput "userForm.password" />
                </div>
            </div>

            <div class="showPassword col-sm-1" style="visibility: hidden">
                <div class="thumbnail" STYLE="border: none;font-size: 20px; color: green">
                    <button type="submit" style="border: none; background-color: white;"  class="glyphicon glyphicon-ok icon-large"></button>
                </div>
            </div>
        </form>
    </div>
</div>
</@page.template>
