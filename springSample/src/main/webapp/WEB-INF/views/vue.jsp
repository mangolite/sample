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
.demoG{
float : left;
width : 500px;
}
</style>

<div id="demo" class="demoG">
	<div v-text="xxx.n"></div>
    <table v-component="grid" v-with="gridOptions"></table>
</div>
<div id="demo2" class="demoG">
	<div v-model="xxx.n"></div>
    <table v-component="grid" v-with="gridOptions"></table>
</div>
<p style="font-size:12px">* You can click on the headers to sort the table.</p>
<div style="clear:both"></div>
<hr/>
<div id="demo3" class="">
	<div v-model="xxx.n"></div>
</div>
<div style="clear:both"></div>
<hr/>
<div id="demo4" class="">
	<div v-model="xxx.n"></div>
</div>
<input class="teest"/> <input class="teest"/>

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
			<td v-repeat="columns" ><input v-model="xxx.n"/></td>
		</tr>
	</tbody>
</table>
</script>

<script>

//raw data
var STORE = {
		data : [
		 { name: 'Chuck Norris', power: Infinity },
		  { name: 'Bruce Lee', power: 9000 },
		 { name: 'Jacky Chang', power: 7000 },
		 { name: 'Jet Li', power: 8000 }
		],
		third : {
			xxx : { n : 'xOK' },yyy : { n : 'yOK' }, count : 0
		}
		
}

// register the grid component
// use `replace: true` because without the wrapping <table>
// the template won't be parsed properly
Vue.component('grid', {
    template: '#grid-template',
  //  replace: true,
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
    	xxx : { n : "dem1111" },
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
    	xxx : { n : "dem2222" },
        gridOptions: {
            data: STORE.data,
            columns: [
                { header: 'Name', key: 'name' },
                { header: 'Power', key: 'power' }
            ]
        }
    }
})

var myTable3 = new Vue({
    el: '#demo3',
    template : '<div v-model="yyy.n"></div><div v-model="count"></div>',
    data: STORE.third
})
var myTable4 = new Vue({
    el: '#demo4',
    template : '<div v-model="yyy.n"  v-on="click:notok"></div><div v-model="zzz.n"></div>',
    data: STORE.third,
    methods : {
    	notok : function(v){
    		this.count++;
    	}
    }
})
</script>
</body>
<script src="/app/resources/dff/dff.init.js"></script>
</html>