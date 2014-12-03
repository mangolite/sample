<%@ taglib uri="/WEB-INF/tags/customTags.tld"  prefix="tt"%>
<div>
	<p>
		Price<input class="tag" type="text" rx-path="detail.price" id="name"
			formatType="number" />
	</p>
	<p>
		Volume<input class="tag" type="text" rx-path="detail.volume"
			formatType="number" id="name" />
	</p>
	<p>
		Details : <b><span rx-path="detail.price"></span>/<span
			rx-path="detail.volume"></span></b> and Rate is <b><span
			rx-path="detail.rate"></span></b>
	</p>
</div>