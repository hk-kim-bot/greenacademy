 let index={
	init: function(){
	$("#btn-join").on("click",()=>{
		this.join();
	});
	$("#btn-update").on("click",()=>{
		this.update();
	})
	},
	join:function(){
		let data={
			username:$("#username").val(),
			password:$("#pwd").val(),
			email:$("#email").val()
		};
		$.ajax({
			type:"POST",
			url:"/auth/joinProc",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
			
		}).done(function(resp){
			alert("회원가입 완료");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		
	},
	update:function(){
		let date={
			id:$("#id").val(),
			password:$("#pwd").val(),
			email:$("#email").val()
		};
		$.ajax({
			type:"PUT",
			url:"/user",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
			
		}).done(function(resp){
			alert("회원수정 완료");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
}
index.init();