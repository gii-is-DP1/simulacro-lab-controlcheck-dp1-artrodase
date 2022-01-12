<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<petclinic:layout pageName="product">
<jsp:body>

		<h2>Create new product!</h2>
    		<form:form modelAttribute="product" class="form-horizontal" id="add-product-form">
        		<div class="form-group has-feedback">
        			<div class="row text-center">
        			<petclinic:inputField label="Name" name="name"/>
        			</div>
        			
        			<div class="row text-center">
        			<petclinic:inputField label="Price" name="price"/>
        			</div>
        			<div class = "control-group">
        			<petclinic:selectField label="productType" name="productType" size="2" names="${prodType }"></petclinic:selectField>
        			</div>
        		    		
            											
        		</div>
        		<div class="form-group">
          			  <div class="col-sm-offset-2 col-sm-8 text-center">
                		<input type="hidden" name="id" value="${product.id}"/>
                		
                		<button class="btn btn-info" type="submit">Create product</button>	
            		  </div>
        		</div>
    		</form:form>
	</jsp:body>
    
</petclinic:layout>