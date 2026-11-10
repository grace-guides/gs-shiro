<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Login</title>
</head>
<body>

<div id="content" role="main">
    <div class="container text-center">
        <section class="row align-self-center">
            <h1>User Login</h1>

            <div class="col-6 offset-3">
            <form action="login" method="post">
                <div class="mb-3 text-start">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" name="username">
                </div>
                <div class="mb-3 text-start">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password">
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
            </div>
        </section>
    </div>
</div>

</body>
</html>
