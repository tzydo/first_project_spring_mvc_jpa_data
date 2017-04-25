<#import "templatePage.ftl" as page>
<#import "/spring.ftl" as spring>
<spring.bind path="userList"/>

<@page.template>
<div class=" col-sm-10">

    <div class="container-fluid">
        <div style="font-size: 20px; margin-bottom: 10px;">
                <i class="fa fa-user-plus" aria-hidden="true" style="color: black;"></i>
        </div>
        <div class="sss"></div>

        <script>
            var x = 0;
            $(".fa-user-plus").click(function(){

                if(x!=0){
                    $(".sss").text(" ");
                    x=0;
                }else {
                    $('.sss').append(
                            '<form action="addEmployee"  role="form" method="post" >'+
                            '<div class="col-sm-12 container-fluid" style="margin-top: 10">'+
                                '<div class="col-sm-2"><input type="text" name="name" placeholder="Name" ></div>' +
                                '<div class="col-sm-2"><input type="text" name="lastName" placeholder="Last Name"></div>' +
                                '<div class="col-sm-2"><input type="text" name="country" placeholder="Country"></div>' +
                                '<div class="col-sm-2"><input type="text" name="login" placeholder="Login"></div> ' +
                                '<div class="col-sm-2"><input type="text" name="password" placeholder="Password"></div>' +

                                '<@spring.bind path="roleList"/>'+
                                '<div class="col-sm-2" >'+
                                ' <select class="selectpicker" style="padding: 3" id="selectRole" name="selectRole">'+
                                '<#list roleList as role>'+
                                '<option>${role.name}</option>'+
                                '</#list>'+
                            '</select>'+
                            '</div>'+


                            '</div>'+
                            '<div class="col-sm-2" style="margin-top: 10; float: right;">' +
                            '<button type="submit" class="btn btn-info">Add</button>'+
                            '</div>'+
                            '</form>')
                    x++;
                          }
            });
        </script>
    </div>
    <table class="table table-responsive table-hover" style="margin-top: 20px;">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Last name</th>
            <th>Country</th>
            <th>Login</th>
            <th>Password</th>
            <th>Role</th>
        </tr>
        </thead>
        <tbody>
            <#list userList as list>

            <tr>

                <td>${list.id_user}</td>
                <td>${list.name}</td>
                <td>${list.last_name}</td>
                <td>${list.country}</td>
                <td>${list.login}</td>
                <td>${list.password}</td>
                <td>${list.role.name}</td>
                <td>
                    <a href="delete/${list.id_user}"
                    <button style="border: none; background-color: #fff" >
                        <i class="fa fa-user-times" aria-hidden="true" style="color: black;"></i>
                    </button>
                    </a>
                </td>
            </tr>

            </#list>
        </tbody>
    </table>
</div>
</@page.template>