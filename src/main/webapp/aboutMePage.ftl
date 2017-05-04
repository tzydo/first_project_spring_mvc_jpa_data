<#import "templatePage.ftl" as page>
<#import "/spring.ftl" as spring>


<@spring.bind "userForm"/>


<@page.template>
    <div  style="text-align: center; font-size: larger;">
    <xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">


        <!--NAME-->


    <div class="row">
        <div class="col-sm-2">
            <div class="thumbnail" STYLE="border: none;">
                <strong>Name :</strong>
            </div>
        </div>

        <div class="col-sm-2"">
        <div class="thumbnail name" >
            <spring.bind path="user"/>
        ${user.name}
        </div>
    </div>

    <div class="showName"> </div>

</div>
<script>
    var x = 0;
    $(".name").click(function(){

        if(x!=0){
            $(".showName").text(" ");
            x=0;
        }else {
            $(".showName").text(" ");
            $('.showName').append(
                    '<div class="col-sm-2 ">' +
                    '<div class="thumbnail" STYLE="border: none;">'+
                    '<strong>Change name: </strong>'+
                    '</div>'+
                    '</div>'+

                    '<form action="changeName"  role="form" method="post">'+
                    '<div class="col-sm-2">'+
                    '<input type="text" name="newName">'+
                    '</div>'+

                    '<div class="col-sm-1" STYLE="border: none;font-size: 20px; color: green">'+
                    '<button type="submit" style="border: none; background-color: white;"'+
                    'class="glyphicon glyphicon-ok icon-large"></button>'+
                    '</div>'+
                    '</form>'
            );
            x++;
        } });
</script>



<!--LASTNAME-->



<div class="row">

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong>Last name :</strong>
        </div>
    </div>

    <div class="col-sm-2">
        <div class="thumbnail lastName">
            <spring.bind path="user"/>
        ${user.last_name}
        </div>
    </div>

    <div class="showLastName"></div>

</div>

<script>
    var x = 0;
    $(".lastName").click(function(){

        if(x!=0){
            $(".showLastName").text(" ");
            x=0;
        }else {
            $(".showLastName").text(" ");
            $('.showLastName').append(
                    '<div class="col-sm-2 ">' +
                    '<div class="thumbnail" STYLE="border: none;">'+
                    '<strong>Change last name :  </strong>'+
                    '</div>'+
                    '</div>'+

                    '<form action="changeLastName"  role="form" method="post">'+
                    '<div class="col-sm-2">'+
                    '<input type="text" name="newLastName">'+
                    '</div>'+

                    '<div class="col-sm-1" STYLE="border: none;font-size: 20px; color: green">'+
                    '<button type="submit" style="border: none; background-color: white;"'+
                    'class="glyphicon glyphicon-ok icon-large"></button>'+
                    '</div>'+
                    '</form>'
            );
            x++;
        } });
</script>



<!--ROLE-->



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


<!--COUNTRY-->

<div class="row">

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong>Country :</strong>
        </div>
    </div>

    <div class="col-sm-2 country">
        <div class="thumbnail">
            <spring.bind path="user"/>
        ${user.country}
        </div>
    </div>

    <div class="newCountry"></div>
</div>
<script>
    var x = 0;
    $(".country").click(function(){

        if(x!=0){
            $(".newCountry").text(" ");
            x=0;
        }else {
            $(".newCountry").text(" ");
            $('.newCountry').append(
                    '<div class="col-sm-2 ">' +
                    '<div class="thumbnail" STYLE="border: none;">'+
                    '<strong>Change country : </strong>'+
                    '</div>'+
                    '</div>'+

                    '<form action="changeCountry"  role="form" method="post">'+
                    '<div class="col-sm-2">'+
                    '<input type="text" name="newCountry">'+
                    '</div>'+

                    '<div class="col-sm-1" STYLE="border: none;font-size: 20px; color: green">'+
                    '<button type="submit" style="border: none; background-color: white;"'+
                    'class="glyphicon glyphicon-ok icon-large"></button>'+
                    '</div>'+
                    '</form>'
            );
            x++;
        } });
</script>

<!--LOGIN-->
<div class="row">

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong>Login :</strong>
        </div>
    </div>

    <div class="col-sm-2 login">
        <div class="thumbnail">
            <spring.bind path="user"/>
        ${user.login}
        </div>
    </div>


    <div class="newLogin"></div>
</div>

<script>
    var x = 0;
    $(".login").click(function(){

        if(x!=0){
            $(".newLogin").text(" ");
            x=0;
        }else {
            $(".newLogin").text(" ");
            $('.newLogin').append(
                    '<div class="col-sm-2 ">' +
                    '<div class="thumbnail" STYLE="border: none;">'+
                    '<strong>Change login : </strong>'+
                    '</div>'+
                    '</div>'+

                    '<form action="changeLogin"  role="form" method="post">'+
                    '<div class="col-sm-2">'+
                    '<input type="text" name="newLogin">'+
                    '</div>'+

                    '<div class="col-sm-1" STYLE="border: none;font-size: 20px; color: green">'+
                    '<button type="submit" style="border: none; background-color: white;"'+
                    'class="glyphicon glyphicon-ok icon-large"></button>'+
                    '</div>'+
                    '</form>'
            );
            x++;
        } });
</script>


<!--PASSWORD-->

<div class="row">

    <div class="col-sm-2">
        <div class="thumbnail" STYLE="border: none;">
            <strong>Password :</strong>
        </div>
    </div>

    <div class="col-sm-2 password">
        <div class="thumbnail">
            <spring.bind path="user"/>
        ${user.password}
        </div>
    </div>

    <div class="newPassword"></div>

</div>


<script>
    var x = 0;
    $(".password").click(function(){

        if(x!=0){
            $(".newPassword").text(" ");
            x=0;
        }else {
            $(".newPassword").text(" ");
            $('.newPassword').append(
                    '<div class="col-sm-2 ">' +
                    '<div class="thumbnail" STYLE="border: none;">'+
                    '<strong>Change password : </strong>'+
                    '</div>'+
                    '</div>'+

                    '<form action="changePassword"  role="form" method="post">'+
                    '<div class="col-sm-2">'+
                    '<input type="text" name="newPassword">'+
                    '</div>'+

                    '<div class="col-sm-1" STYLE="border: none;font-size: 20px; color: green">'+
                    '<button type="submit" style="border: none; background-color: white;"'+
                    'class="glyphicon glyphicon-ok icon-large"></button>'+
                    '</div>'+
                    '</form>'
            );
            x++;
        } });
</script>


</div>
</@page.template>
