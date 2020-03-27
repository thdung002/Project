<template>
    <transition name="modal">
        <div class="modal-mask">
            <div class="modal-wrapper">
                <div class="modal-container">
                    <button type="button" class="close" @click="$emit('close')" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>

                    <div class="modal-body">
                        <slot name="body">
                            default body
                        </slot>
                    </div>

                    <div class="modal-footer">
                        <slot name="footer">

                            <button class="btn btn-success" @click="$emit('close')">
                                OK
                            </button>
                        </slot>
                    </div>
                </div>
            </div>
        </div>
    </transition>

</template>

<script>
    export default {
        name: "Details"
    }
</script>

<style scoped>
    @import "../assets/Lib/css/font-face.css";
    @import "../assets/Lib/vendor/font-awesome-4.7/css/font-awesome.min.css";
    @import "../assets/Lib/vendor/font-awesome-5/css/fontawesome-all.min.css";
    @import "../assets/Lib/vendor/mdi-font/css/material-design-iconic-font.min.css";
    @import "../assets/Lib/vendor/bootstrap-4.1/bootstrap.min.css";
    @import "../assets/Lib/vendor/animsition/animsition.min.css";
    @import "../assets/Lib/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css";
    @import "../assets/Lib/vendor/wow/animate.css";
    @import "../assets/Lib/vendor/css-hamburgers/hamburgers.min.css";
    @import "../assets/Lib/vendor/slick/slick.css";
    @import "../assets/Lib/vendor/select2/select2.min.css";
    @import "../assets/Lib/vendor/perfect-scrollbar/perfect-scrollbar.css";
    @import "../assets/Lib/css/theme.css";
    .modal-mask {
        position: fixed;
        z-index: 9998;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        display: table;
        transition: opacity 0.3s ease;
    }

    .modal-wrapper {
        display: table-cell;
        vertical-align: middle;
    }

    .modal-container {
        width: 500px;
        margin: 0px auto;
        padding: 20px 30px;
        background-color: #fff;
        border-radius: 2px;
        box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
        transition: all 0.3s ease;
        font-family: Helvetica, Arial, sans-serif;
    }

    .modal-header h3 {
        margin-top: 0;
        color: #42b983;
    }

    .modal-body {
        margin: 20px 0;
    }

    .modal-default-button {
        float: right;
    }

    /*
     * The following styles are auto-applied to elements with
     * transition="modal" when their visibility is toggled
     * by Vue.js.
     *
     * You can easily play with the modal transition by editing
     * these styles.
     */

    .modal-enter {
        opacity: 0;
    }

    .modal-leave-active {
        opacity: 0;
    }

    .modal-enter .modal-container,
    .modal-leave-active .modal-container {
        -webkit-transform: scale(1.1);
        transform: scale(1.1);
    }

</style>