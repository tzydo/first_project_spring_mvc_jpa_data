<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>

        body{
            background-color:#0666b3;
        }
        #iconTop{
            font-size: 700%;
            text-align: center;
        }

    </style>
</head>
<body>

<div class="container" style="height:200px;"> </div>
<div id="iconTop" style="margin-bottom: 20px;"><i class="fa fa-user-circle" aria-hidden="true"></i></div>


<div class="container">
    <div class="row">
        <div class="col-sm-4"></div>

        <div class="col-sm-4"  style=" background-color:#2881c7; border-style: solid; border-radius: 20px;">
            <form action="/check" method="post" role="form" class="form-horizontal">

                <div class="form-group" style="height: 40px;"> </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="login"><i class="fa fa-user" style="font-size: 25px;" aria-hidden="true"></i></label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="login" placeholder="Enter login">
                    </div>
                </div>

                <div class="form-group" style="height: 20px;"> </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="password"><i class="fa fa-lock" style="font-size: 25px;" aria-hidden="true"></i></label>
                    <div class="col-sm-8" style="font-size: 20px;">
                        <input type="password" class="form-control" name="password" placeholder="Enter password">
                    </div>
                </div>

                <div class="form-group" style="height: 20px;"> </div>


                <div class="form-group">
                    <div class="col-sm-12" style="text-align: center;">
                        <button type="submit" style="background-color: #2881c7;border: none;"  > <i class="fa fa-sign-in" style="border: none; background-color:#2881c7; font-size: 50px;" aria-hidden="true"></i></button>
                    </div>
                </div>
                <div class="form-group" style="height: 20px;"> </div>

            </form>

        </div>
        <div class="col-sm-4">
        </div>
    </div>

</body>
</html>