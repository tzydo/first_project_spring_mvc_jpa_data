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
                <div class="thumbnail">
                    <spring.bind path="user"/>
                    ${user.name}
                </div>
             </div>

            <div class="col-sm-2">
                <div class="thumbnail" STYLE="border: none;">
                    <strong> Change name : </strong>
                </div>
            </div>

            <form action="changeName"  role="form" method="post" ">
                    <div class="col-sm-2">
                        <div class="thumbnail" STYLE="border: none;">
                            <#--<input type="text" name="new name">-->
                            <@spring.formInput "userForm.name" />
                        </div>
                    </div>

                    <div class="col-sm-1">
                        <div class="thumbnail" STYLE="border: none;font-size: 20px; color: green">
                            <button type="submit" style="border: none; background-color: white;"
                                    class="glyphicon glyphicon-ok icon-large"></button>
                        </div>
                    </div>
            </form>

    </div>



<#--Lastname-->
<div class="row">

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong>Last name :</strong>
        </div>
    </div>

    <div class="col-sm-2"">
        <div class="thumbnail">
            <spring.bind path="user"/>
            ${user.last_name}
        </div>
    </div>

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong> Change last name : </strong>
        </div>
    </div>
    <form action="changeLastName"  role="form" method="post" ">
        <div class="col-sm-2">
            <div class="thumbnail" STYLE="border: none;">
                <@spring.formInput "userForm.last_name" />
            </div>
        </div>

        <div class="col-sm-1">
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

    <div class="col-sm-2"">
    <div class="thumbnail">
        <spring.bind path="user"/>
    ${user.role.name}
    </div>
    </div>

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong> Change role : </strong>
        </div>
    </div>

    <form action="changeRole"  role="form" method="post" ">
        <div class="col-sm-2">
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


        <div class="col-sm-1">
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

    <div class="col-sm-2"">
    <div class="thumbnail">
        <spring.bind path="user"/>
    ${user.country}
    </div>
    </div>

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong> Change country : </strong>
        </div>
    </div>

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <@spring.formInput "userForm.country" />
        </div>
    </div>

    <div class="col-sm-1">
        <div class="thumbnail" STYLE="border: none;font-size: 20px; color: green">
            <span class="glyphicon glyphicon-ok"></span>
        </div>
    </div>

    <div class="center-block">
        <span class="label label-danger"><@spring.showErrors ""/></span>
    </div>
</div>



<#--Login-->
<div class="row">

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong>Login :</strong>
        </div>
    </div>

    <div class="col-sm-2"">
    <div class="thumbnail">
        <spring.bind path="user"/>
    ${user.login}
    </div>
    </div>

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong> Change login : </strong>
        </div>
    </div>

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <@spring.formInput "userForm.login" />
        </div>
    </div>

    <div class="col-sm-1">
        <div class="thumbnail" STYLE="border: none;font-size: 20px; color: green">
            <span class="glyphicon glyphicon-ok"></span>
        </div>
    </div>

    <div class="center-block">
        <span class="label label-danger"><@spring.showErrors ""/></span>
    </div>
</div>



<#--Password-->
<div class="row">

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong>Password :</strong>
        </div>
    </div>

    <div class="col-sm-2"">
    <div class="thumbnail">
        <spring.bind path="user"/>
    ${user.password}
    </div>
    </div>

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong> Change password : </strong>
        </div>
    </div>

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <@spring.formInput "userForm.password" />
        </div>
    </div>

    <div class="col-sm-1">
        <div class="thumbnail" STYLE="border: none;font-size: 20px; color: green">
            <span class="glyphicon glyphicon-ok"></span>
        </div>
    </div>

    <div class="center-block">
        <span class="label label-danger"><@spring.showErrors ""/></span>
    </div>
    </div>
</div>
</@page.template>
