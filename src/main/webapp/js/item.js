$(function(){
	/*评星*/
	$.fn.raty.defaults.path = 'js/img';
	$('#star').raty({ 
		hints:['很差', '差', '一般吧', '挺好的', '好级了'],
		readOnly: true, 
		score: 3.5
	});
	$("#close").click(function(){
		var classname = $("#introduce pre").hasClass("introduce_close");
		if(classname){
			$("#introduce pre").removeClass("introduce_close");
			$(this).html("收起↑");
		}else{
			$("#introduce pre").addClass("introduce_close");
			$(this).html("展开↓");
		}
	});
	/*评论评分*/
	$('.comment_star').raty({ 
		hints:['很差', '差', '一般吧', '挺好的', '好级了'],
		readOnly: true, 
		size     : 15,
		score:function(){return $(this).attr("star-num")}
	});

	$('.comment_like').click(function(){
		alert("dfasdsf");
	});

	$('.comment').scrollspy({
		animation: 'slide-bottom',
		delay: 500
	});
	var comment_score;
	$('#input_star').raty({
		hints:['很差', '差', '一般吧', '挺好的', '好级了'],
		half:true,
		target:'#input_star_score',
		targetType: 'number',
		score: function(){
			return $(this).attr('data-score');
		},
		click: function(score, evt) {
			$(this).attr('data-score',score);
			var comment_score = score;
		}
	});

	$("#comment_star").click(function(){
		alert($('#input_star').attr('data-score'));
		alert("提交成功");
		$('#doc-oc-demo3').offCanvas('close');
	});
});