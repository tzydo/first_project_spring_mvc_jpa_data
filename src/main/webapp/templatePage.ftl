<#macro template>
    <#import "/spring.ftl" as spring>
        <spring.bind path="user"/>
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <title>Bootstrap Example</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


            <style>

                .affix {
                    top: 120px;
                }

            </style>
        </head>
        <body>

        <div class="container-fluid" style="background-color:#2196F3;color:#fff;height:150px;" >
            <div class="row">
                <div class="col-sm-1" ></div>
                <div class="col-sm-11" style="vertical-align:middle;align:center; " >
                    <h1>Welcome</h1>
                    <h4><strong>${name} ${lastName}</strong></h4>
                </div>
            </div>
        </div>

        <div class="container-fluid" style="margin-top: 2%;">

            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-2" >
                    <p style="font-size: 30px;">Information</p>
                    <ul class="nav nav-pills nav-stacked" data-spy="affix" data-offset-top="205" style="font-size:20px;">
                        <li><a href="/adminPanel/userPage">About Me</a></li>
                        <li><a href="/adminPanel/employeeList">Employee</a></li>
                        <li><a href="#section3">Products</a></li>
                        <li><a href="#section3">Products List</a></li>
                        <li><a href="#section3">Sold Products</a></li>
                        <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                    </ul>
                </div>

                <div class="col-sm-9">
                    <div class="container-fluid">
                        <#nested>
                    </div>
                </div>
            </div>
        </div>


        </body>
        </html>
</#macro>