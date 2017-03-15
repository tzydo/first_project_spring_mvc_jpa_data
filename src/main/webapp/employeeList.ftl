<#import "templatePage.ftl" as page>
<#import "/spring.ftl" as spring>
<spring.bind path="userList"/>

<@page.template>
<div class="container-fluid col-sm-9">

    <table class="table table-responsive table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Country</th>
            <th>Login</th>
            <th>Password</th>
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