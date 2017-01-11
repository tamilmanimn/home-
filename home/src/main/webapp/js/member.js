$(document).ready(function(){
	$(document).on("click","#addSub",function(){
		var mid=$("#mid").val();
		var mname=$("#mname").val();
		var dob=$("#dob").val();
		var mno=$("#mno").val();
		if(mid==""){
			$("#mid").focus().css("outline-color","red");
			return;
		}
		if(mname==""){
			$("#mname").focus().css("outline-color","red");
			return;
		}
		if(dob==""){
			$("#dob").focus().css("outline-color","red");
			return;
				
		}
		if(mno==""){
			$("#mno").focus().css("outline-color","red");
			return;
		}
		var url="/home/home?operation=addMember&mid="+mid+"&mname="+mname+"&dob="+dob+"&mno="+mno;
		
		$.ajax({
			url:url,
			type:'POST'
		}).done(function(result){
			alert("Successfully Added");
		}).fail(function(result){
			alert("Please Check Deatils");
		})
	});
	$(document).on("click","#update",function(){
		var mid=$("#mid").val();
		var mname=$("#mname").val();
		var dob=$("#dob").val();
		var mno=$("#mno").val();
		if(mid==""){
			$("#mid").focus().css("outline-color","red");
			return;
		}
		if(mname==""){
			$("#mname").focus().css("outline-color","red");
			return;
		}
		if(dob==""){
			$("#dob").focus().css("outline-color","red");
			return;
		}
		if(mno==""){
			$("#mno").focus().css("outline-color","red");
			return;
		}
		var url="/home/home?operation=updateMember&mid="+mid+"&mname="+mname+"&dob="+dob+"&mno="+mno;
		$.ajax({
			url:url,
			type:'POST'
		}).done(function(result){
			alert("Update Successfully");
		}).fail(function(result){
			alert("Error accurs");
		})
	
	});
	
	$(document).on("keyup","#mid",function(){
		var mid=$("#mid").val();
		if(mid !=""){
			var url="/home/home?operation=getOne&id="+mid;
			$.ajax({
				url:url,
				type:'POST'
			}).done(function(result){
				result=JSON.parse(result);
				$("#mname").val(result.name);
				$("#dob").val(result.dob);
				$("#mno").val(result.mobilenumber);
			})
		}
	});
	
	$(document).on("click","#getAll",function(){
		var url = "/home/home?operation=getAll";
		$.ajax({
			url : url,
			type : 'POST'
		})
		.done(function(result) {
			var array = JSON.parse(result);
			var table = "<table border=2px>";
			table += "<tr><th>MemberId</th><th>Name</th><th>DateOfBirth</th><th>MObileNumber</th></tr>";
			for (i = 0; i < array.length; i++) {
			table += "<tr>";
			table += "<td>"+ array[i].memberid+ "</td>";
			table += "<td>"+ array[i].name+ "</td>";
			table += "<td>"+ array[i].dob+ "</td>";
			table += "<td>"+ array[i].mobilenumber+ "</td>";
			table += "</tr>";
          }
			table += "</table>";
			$('.getAll')[0].innerHTML = table;
		});
	})
	
	$(document).on("click","#add",function(){
		var id=$("#id").val();
		var sal=$("#sal").val();
		if(id==""){
			$("#id").focus().css("outline-color","red");
			return;
		}
		if(sal==""){
			$("#sal").focus().css("outline-color","red");
			return;
		}
		var url="/home/home?operation=addSalary&id="+id+"&salary="+sal;
		
		$.ajax({
			url:url,
			type:'POST'
		}).done(function(result){
			alert("Successfully Added");
			
		}).fail(function(result){
			alert("Error Accours");
		})
	});
	
	$(document).on("click","#updat",function(){
		var id=$("#id").val();
		var sal=$("#sal").val();
		if(id==""){
			$("#id").focus().css("outline-color","red");
			return;
		}
		if(sal==""){
			$("#sal").focus().css("outline-color","red");
			return;
		}
		var url="/home/home?operation=updateSalary&id="+id+"&salary="+sal;
		
		$.ajax({
			url:url,
			type:'POST'
		}).done(function(result){
			alert("Update Successfully");
			
		}).fail(function(result){
			alert("Error Accours");
		})
	});
	
	$(document).on("keyup","#id",function(){
		var id=$("#id").val();
		if(id !=""){
			var url="/home/home?operation=oneSalary&id="+id;
			$.ajax({
				url:url,
				type:'POST'
			}).done(function(result){
				result=JSON.parse(result);
				$("#sal").val(result.salary);
			})
		}
	});
	
	$(document).on("click","#allSalary",function(){
		var url = "/home/home?operation=allSalary";
		$.ajax({
			url : url,
			type : 'POST'
		})
		.done(function(result) {
			var array = JSON.parse(result);
			var table = "<table border=2px>";
			table += "<tr><th>MemberId</th><th>Salary</th></tr>";
			for (i = 0; i < array.length; i++) {
			table += "<tr>";
			table += "<td>"+ array[i].memberid+ "</td>";
			table += "<td>"+ array[i].salary+ "</td>";
			table += "</tr>";
          }
			table += "</table>";
			$('.allSalary')[0].innerHTML = table;
		});
	})
	
	
	
	
	
	
	
})