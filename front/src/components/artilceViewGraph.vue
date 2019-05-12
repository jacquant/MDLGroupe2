<template>
    <div>
        <div class="popover" id="popover"></div>
        <div id="container"> </div>
    </div>
</template>

<script>
    export default {
        name: "artilceViewGraph",
        mounted(){
            let graph = document.createElement('script')
            graph.setAttribute('src', './artilceViewGraph/graph.js')
            document.head.appendChild(graph)
        }

    }
</script>

<style scoped>

</style>