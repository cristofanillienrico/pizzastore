<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
	<head>
		<jsp:include page="/header.jsp" />
		<title>Registrazione</title>
		
		<!-- style per le pagine diverse dalla index -->
	    <link href="${pageContext.request.contextPath }/assets/css/global.css" rel="stylesheet">
	    
	</head>
	<body>
		<jsp:include page="/navbar.jsp" />

	
		<main role="main" class="container">
		
		<%-- alert con lista errori --%>
		<div class="alert alert-danger ${registration_utente_attr.hasErrors()?'':'d-none'}" role="alert">
			<c:forEach var ="errorItem" items="${registration_utente_attr.errors }">
	        	<ul>
					<li> ${errorItem }</li>	
				</ul>
	      	</c:forEach>
		</div>
		
			<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
			  ${errorMessage}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
			
			<div class='card'>
			    <div class='card-header'>
			        <h5>Registrati</h5> 
			    </div>
			    <div class='card-body'>
			    
			    		<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
	
						<form method="post" action="${pageContext.request.contextPath}/registration/ExecuteIscrivitiServlet" novalidate="novalidate" >
						
							<div class="form-row">
								<div class="form-group col-md-6">
									<label>Nome <span class="text-danger">*</span></label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome" value="${registration_utente_attr.nome }" required>
								</div>
								
								<div class="form-group col-md-6">
									<label>Cognome <span class="text-danger">*</span></label>
									<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire il cognome" value="${registration_utente_attr.cognome }" required>
								</div>
							</div>
							
							
							<div class="form-row">
								<div class="form-group col-md-6">
									<label>Username <span class="text-danger">*</span></label>
									<input type="text" autocomplete="nope" name="username" id="username" class="form-control" placeholder="Inserire username" value="${registration_utente_attr.username }" required>
								</div>
								
								<div class="form-group col-md-6">
									<label>Password <span class="text-danger">*</span></label>
									<input type="password" autocomplete="new-password" class="form-control" name="password" id="password" placeholder="Inserire password" value="" required>
								</div>
								
								<div class="form-group col-md-6">
									<label>Conferma Password <span class="text-danger">*</span></label>
									<input type="password"  class="form-control" name="confermaPassword" id="confermaPassword" placeholder="Conferma password" value="" required>
								</div>
								
								<div class="form-group col-md-6">
									<div class="form-check">
							
								
							</div>
								</div>
								
							</div>
			
								
							<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
	
						</form>
			    
				<!-- end card-body -->			   
			    </div>
			</div>	
		
		
		<!-- end container -->	
		</main>
		<jsp:include page="../footer.jsp" />
		
	</body>
</html>