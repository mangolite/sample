<%@ taglib uri="/WEB-INF/tags/customTags.tld"  prefix="tt"%>
<div>
	<p>
		Price<input class="tag" type="text" data-path="detail.price" id="name"
			formatType="number" />
	</p>
	<p>
		Volume<input class="tag" type="text" data-path="detail.volume"
			formatType="number" id="name" />
	</p>
	<p>
		Details : <b><span data-path="detail.price"></span>/<span
			data-path="detail.volume"></span></b> and Rate is <b><span
			data-path="detail.rate"></span></b>
	</p>
</div>