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