<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form modelAttribute="usuario" action="executarRegistro" enctype="multipart/form-data">
	
	<label for="nome">Nome:<sf:errors path="nome" cssClass="erro"></sf:errors></label>
	<sf:input path="nome"/>
	
	<label for="email">Email</label>
	<sf:input path="email"/>
	
	<label for="login">Nome do Usuario (login)</label>
	<sf:input path="login"/>
	
	<label for="senha">Senha</label>
	<sf:password path="senha"/>
	
	<label for="avatar">Avatar:</label>
	<input type="file" name="avatar"/>
	
	<input type="submit" value="Faça parte!"/>
</sf:form>