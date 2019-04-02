<template>
    <div>
        <p class="main-header">DESIGN</p>
        <!--https://i.dlpng.com/static/png/304381_thumb.png-->

        <div id="preview-div">
            <div id="img-container">
                <img id="img-background" src="https://i.dlpng.com/static/png/304381_thumb.png" width="315" height="315"/>
                <img id="preview" src="https://via.placeholder.com/215/f3f3ef/000000?text=PREVIEW" width="140" height="140"/>
            </div>
        </div>

        <!--<img id="preview" src="https://via.placeholder.com/300/efefef/000000?text=PREVIEW" alt="preview" width="300" height="300" />-->
        <!--<img src="https://via.placeholder.com/300/efefef/000000?text=PREVIEW" alt="product">-->

        <div id="parameters">
            <p>Choose material:</p>
            <select name="material" id="material-select">
                <option value="cotton" selected>Cotton</option>
                <option value="poly">Poly</option>
                <option value="cotton-poly">Cotton+Poly</option>
            </select>
            <p>Choose size:</p>
            <input class="radio-choice" id="xs" type="radio" name="size" value="xs"><label for="xs">XS</label><br/>
            <input class="radio-choice" id="s" type="radio" name="size" value="s"><label for="s">S</label><br/>
            <input class="radio-choice" id="m" type="radio" name="size" value="m"><label for="m">M</label><br/>
            <input class="radio-choice" id="l" type="radio" name="size" value="l"><label for="l">L</label><br/>
            <input class="radio-choice" id="xl" type="radio" name="size" value="xl"><label for="xl">XL</label><br/>
            <input id="choose-img-btn" type="file" value="val" name="choose-img-btn" accept="image/png" onchange="document.getElementById('preview').src = window.URL.createObjectURL(this.files[0])">
            <!--<button onclick="if (window.File && window.FileReader && window.FileList && window.Blob) {alert('works')
             } else { alert('The File APIs are not fully supported in this browser.'); }">Check if works</button>-->
            <!--<button onclick="console.log(document.getElementById('choose-img-btn').value)">Upload .png</button>-->
        </div>

        <!--<input id="order-btn" type="submit" value="ORDER" onload="document.getElementById('choose-img-btn').addEventListener('change', handleFileSelect, false);">-->
        <input id="order-btn" type="submit" value="ADD TO CART" v-on:click='addDesign()'>
    </div>
</template>

<script>
    export default {
        name: "Design"
    }
</script>

<style scoped>
/*#preview {
    display: inline-block;
}
#parameters {
    display: inline-block;
    z-index: 200;
}
#order-btn {
    display: block;
}
#preview-div {
    padding: 10px;
    display: block;
}
#img-container {
    position: relative;
    display: block;
}
#img-background {
    width: 25%;
    height: auto;
    position: absolute;
    top: auto;
    left: auto;
    z-index: 1;
}
#preview {
    position: absolute;
    top: auto;
    left: auto;
    z-index: 3;
}*/
body {
    display: flex;
    flex-direction: column;
    align-items: center;
}
#preview-div {
    display: inline-block;
    padding: 0;
    min-width: 315px;
    min-height: 315px;
    float: left;
    margin-right: 20px;
    margin-top: 10px;
    overflow: visible;
}
#img-container {
    position: relative;
    display: inline-block;
}
#img-background {
    position: absolute;
}
#preview {
    position: absolute;
    top: 85px;
    left: 86px;
}
#parameters {
    display: inline-block;
}
label {
    color: dodgerblue;
    display: inline-block;
    vertical-align: middle;
    cursor: pointer;
    margin-left: 5px;
}
#choose-img-btn {
    display: block;

}
#parameters input {

}
.radio-choice {
    text-decoration: none;
    cursor: pointer;
    vertical-align: middle;
}
input[type="radio"] {
    /*-webkit-appearance: radio;
    -moz-appearance: radio;
    appearance: radio;*/
}
input[type="radio"]:checked {

}
#order-btn {
    display: block;
}
#choose-img-btn {
    background-color: lightsteelblue;
    text-decoration: none;
    border: none;
    color: white;
    padding: 4px 18px;
    text-align: center;
    font-size: 14px;
    margin-top: 5px;
    /*display: inline-block;*/
}
#choose-img-btn:focus {
    outline: 0;
}
#choose-img-btn:hover {
    background-color: dimgray;
    color: white;
}
#order-btn {
    margin-top: 15px;
    background-color: dodgerblue;
    text-decoration: none;
    border: none;
    color: white;
    padding: 12px 32px;
    text-align: center;
    font-size: 16px;
}
#order-btn:focus {
    outline: 0;
}
#order-btn:hover {
    background-color: black;
    color: white;
}
.main-header {
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    font-size: 28px;
    font-weight: bold;
    margin-left: 30px;
}
p {
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    font-size: 20px;
}
label {
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    font-size: 14px;
}
</style>