<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grace</title>
</head>
<body>

<div id="content" role="main">
    <div class="container">
        <section class="row">
            <shiro:guest><h1>Welcome, Guest!</h1></shiro:guest>
            <shiro:user><h1>Welcome, <shiro:principal/></h1></shiro:user>

            <shiro:guest>
            <p>
                Congratulations, you have successfully started your first Grace application! At the moment
                this is the default page, feel free to modify it to either redirect to a controller or display
                whatever content you may choose. Below is a list of controllers that are currently deployed in
                this application, click on each to execute its default action:
            </p>
            </shiro:guest>
            
            <div id="controllers" role="navigation">
                <h2>Available Controllers:</h2>
                <ul>
                    <shiro:guest>
                        <li><g:link controller="auth" action="index">Login</g:link></li>
                    </shiro:guest>
                    <shiro:user>
                        <li><g:link controller="auth" action="logout">Logout</g:link></li>
                    </shiro:user>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
        </section>
    </div>
</div>

</body>
</html>
