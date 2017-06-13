<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .content-body {
        height: 400px;
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
        justify-content: center;
        align-items: center;
    }

    .welcome-h1 {
        font-size: 3.2rem;
        text-align: center;
    }

    .welcome-h2 {
        font-size: 2.8rem;
        text-align: center;
    }

    @media (max-width: 700px)  {
        .welcome-h1 {
            font-size: 20px;
        }

        .welcome-h2 {
            font-size: 18px;
        }
    }
</style>
<div class="content-body z-depth-1" data-page-name="Home">
    <h1 class="welcome-h1">Welcome, <span class="user-name">!</span></h1>
    <h2 class="welcome-h2">Use toolbar for navigation. Good luck!</h2>
</div>
<script>
    $(".welcome-h1 .user-name").html($("#user-name").html());
</script>