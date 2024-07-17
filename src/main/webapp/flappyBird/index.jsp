<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/flappyBird/style.css">
</head>

<body>
    <div id="container" onclick="upper()">
        <div id="line-div"></div>
        <div id="bird">
            <img id="bird1img" src="/flappyBird/img/bird1.png" alt="bird">
        </div>
        <div id="pipe1">
            <img id="pipe1img" src="/flappyBird/img/pipe.png" alt="pipe">
        </div>
        <div id="piperotate1">
            <img id="pipe1imgrotate" src="/flappyBird/img/pipe.png" alt="piperotate">
        </div>
        <div id="pipe2">
            <img id="pipe2img" src="/flappyBird/img/pipe.png" alt="pipe">
        </div>
        <div id="piperotate2">
            <img id="pipe2imgrotate" src="/flappyBird/img/pipe.png" alt="piperotate">
        </div>
        <div id="background">
            <img src="/flappyBird/img/bgflappy.jpg" alt="background">
        </div>
        <div id="base1">
            <img id="base1img" src="/flappyBird/img/base.png" alt="base">
        </div>
        <div id="base2">
            <img id="base2img" src="/flappyBird/img/base.png" alt="base">
        </div>
        <img id="startgame" src="/flappyBird/img/startgame.png" alt="startgame">
        <img id="gameover" src="/flappyBird/img/gameover.png" alt="gameover">
        <h2 id="score"></h2>
    </div>
    <script src="/flappyBird/main.js"></script>
</body>

</html>