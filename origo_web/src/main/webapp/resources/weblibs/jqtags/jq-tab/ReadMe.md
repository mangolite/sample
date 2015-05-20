Sample Code: 
```html
	<jq-tab value="gen" id="sampeltab" onchange="console.log('tab change')">
		<jq-tab-head value="gen">General</jq-tab-head>
		<jq-tab-head value="vdo">Video</jq-tab-head>
		<jq-tab-head value="pic">Pics</jq-tab-head>
		
		<jq-tab-pane tab-value="gen">I am gen Content</jq-tab-pane>
		<jq-tab-pane tab-value="vdo" >I am vdo Content</jq-tab-pane>
		<jq-tab-pane tab-value="pic">I am pic Content</jq-tab-pane>
	</jq-tab>
```
Using jQuery you can get/set value

```javascript
$("sampeltab").val("pic");

var x = $("sampeltab").val();

$("sampeltab").on("change",function(e){
    console.log("callback : tab has changes")
})


```

# Install


```console
composer require jqtags/jq-tab

bower install jqtags-jq-tab

```