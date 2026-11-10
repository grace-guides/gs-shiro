<!doctype html>
<html>
<head>
    <title>Post List</title>
    <meta name="layout" content="main">
</head>
<body>

<div class="container">
    <section class="row">
        <h1>Post List</h1>
        <h5>${flash.message}</h5>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${postList}" var="post">
                <tr>
                    <td>${post.id}</td>
                    <td>${post.title}</td>
                </tr>
                </g:each>
            </tbody>
        </table>
    </section>
</div>

</body>
</html>
