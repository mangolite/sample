<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Hello WebSocket</title>
<script src="/app/resources/utils/jquery-latest.js"></script>
<script src="/app/resources/utils/utils.js"></script>
<script src="/app/resources/utils/bootstrap.js"></script>
<script src="/app/resources/tools/vue.js?no"></script>
</head>
<body>
<style type="text/css">
body {
    font-family: Helvetica Neue, Arial, sans-serif;
    font-size: 14px;
    color: #444;
}
table {
    border: 2px solid #42b983;
    border-radius: 3px;
    background-color: #fff;
}
th {
    background-color: #42b983;
    color: #fff;
    cursor: pointer;
}
td {
    background-color: #f3f3f3;
}
th, td {
    padding: 10px 20px;
}
</style>

<div id="demo">
    <table v-component="grid" v-with="gridOptions"></table>
</div>
<div id="demo2">
    <table v-component="grid" v-with="gridOptions"></table>
</div>
<p style="font-size:12px">* You can click on the headers to sort the table.</p>

<script type="text/x-template" id="grid-template">
    <table>
        <thead>
            <tr>
                <th v-repeat="columns" v-on="click:sortBy(key)">{{header}}</th>
            </tr>
        </thead>
        <tbody>
            <tr v-repeat="data">
                <!-- access outer loop's data using $parent -->
                <td v-repeat="columns">{{$parent[key]}}</td>
            </tr>
        </tbody>
    </table>
</script>

<script>

//raw data
var STORE = {
		data : {
		 x :       { name: 'Chuck Norris', power: Infinity },
		 y:        { name: 'Bruce Lee', power: 9000 },
		  z:       { name: 'Jacky Chang', power: 7000 },
		   w :     { name: 'Jet Li', power: 8000 }
		}
}

// register the grid component
// use `replace: true` because without the wrapping <table>
// the template won't be parsed properly
Vue.component('grid', {
    template: '#grid-template',
    replace: true,
    created: function () {
        this.ascending = {}
    },
    methods: {
        sortBy: function (key) {
            var asc = this.ascending[key] = !this.ascending[key]
            this.data.sort(function (a, b) {
                var res = a[key] > b[key]
                if (asc) res = !res
                return res ? 1 : -1
            })
        }
    }
})

// bootstrap the demo
var myTable = new Vue({
    el: '#demo',
    data: {
        gridOptions: {
            data: STORE.data,
            columns: [
                { header: 'Name', key: 'name' },
                { header: 'Power', key: 'power' }
            ]
        }
    }
})
var myTable2 = new Vue({
    el: '#demo2',
    data: {
        gridOptions: {
            data: STORE.data,
            columns: [
                { header: 'Name', key: 'name' },
                { header: 'Power', key: 'power' }
            ]
        }
    }
})

</script>
</body>
<script src="/app/resources/dff/dff.init.js"></script>
</html>