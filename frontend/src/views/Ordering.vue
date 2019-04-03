<template>
    <div>
        <p class="main-header">Checkout</p>
        <form action="">
                <legend>My information:</legend>
                <div class="leftside">
                    First name:<br>
                    <input type="text" name="firstname" value=""><br>
                    Last name:<br>
                    <input type="text" name="lastname" value=""><br>
                </div>
                <div class="rightside">
                    Email:<br>
                    <input type="text" name="email" value=""><br>
                    Tel:<br>
                    <input type="text" name="tel" value=""><br>
                </div>
                <legend>Shipping information:</legend>
                <div id="shipping-choice">
                    Shipping:<br>
                    <select id="shipping" name="shipping">
                        <option value="omniva">OMNIVA</option>
                        <option value="dpd">DPD</option>
                        <option value="itella">Itella</option>
                    </select><br>
                </div>
                <div class="leftside">
                    Maakond:<br>
                    <input type="text" name="county" value=""><br>
                    Linn:<br>
                    <input type="text" name="county" value=""><br>
                </div>
                <div class="rightside">
                    Vald:<br>
                    <input type="text" name="subregion" value=""><br>
                    Küla/alevik:<br>
                    <input type="text" name="village" value=""><br>
                </div>
                <div class="leftside">
                    Tänav:<br>
                    <input type="text" name="street" value=""><br>
                    Maja:<br>
                    <input type="text" name="house" value=""><br>
                </div>
                <div class="rightside">
                    Korter:<br>
                    <input type="text" name="flat" value=""><br>
                    Postiindeks:<br>
                    <input type="text" name="zipcode" value=""><br>
                </div>
                <div id="comments-div">
                    Comments:<br>
                    <textarea name="" id="comments" placeholder="Any comments go here" cols="50" rows="5"></textarea><br>
                </div>
            <div onclick="alert('Order submitted! Have a nice day:)')">
                <router-link to="/home"><input type="submit" value="ORDER"></router-link>
            </div>
        </form>
    </div>
</template>

<script>
    export default {
        name: "Ordering"
    }
</script>

<style scoped>
    input[type=text], select, textarea {
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        margin-top: 6px;
        margin-bottom: 14px;
        resize: vertical;
    }
    #comments {

    }
    .rightside {
        float: contour;
    }
    .leftside {
        float: left;
        margin-left: 10px;
        margin-right: 5px;
    }
    input[type=submit] {
        margin-left: 10px;
        background-color: dodgerblue;
        text-decoration: none;
        border: none;
        color: white;
        padding: 12px 32px;
        text-align: center;
        font-size: 16px;
        margin-bottom: 10px;
    }
    legend {
        margin-left: 10px;
    }
    #shipping-choice {
        margin-left: 10px;
    }
    #comments-div {
        margin-left: 10px;
    }
    p {
        margin-left: 10px;
    }
    html, body {
        position: relative;
        margin: 0;
        padding: 0;
        overflow: auto;
    }
    .main-header {
        font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
        font-size: 28px;
        font-weight: bold;
    }
    legend {
        font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
        font-size: 20px;
        text-decoration-line: underline;
    }
    .leftside, .rightside, #comments-div, #shipping-choice {
        font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
        font-size: 14px;
    }
</style>