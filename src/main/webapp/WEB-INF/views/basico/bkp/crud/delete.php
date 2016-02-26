<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta charset="utf-8">
        <link   href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container">

            <div class="span10 offset1">
                <div class="row">
                    <h3>Delete a Customer</h3>
                </div>

                <form class="form-horizontal" action="delete.php" method="post">
                    <input type="hidden" name="id" value="<?php echo $id; ?>"/>
                    <p class="alert alert-error">Are you sure to delete ?</p>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-danger">Yes</button>
                        <a class="btn" href="index.php">No</a>
                    </div>
                </form>
            </div>

        </div> <!-- /container -->
    </body>
</html>