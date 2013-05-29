<%@ page import="com.example.helloworld.core.Person" %>



<div class="fieldcontain ${hasErrors(bean: person, field: 'fullName', 'error')} ">
	<label for="fullName">
		<g:message code="person.fullName.label" default="Full Name" />
		
	</label>
	<g:textField name="fullName" value="${person?.fullName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: person, field: 'jobTitle', 'error')} ">
	<label for="jobTitle">
		<g:message code="person.jobTitle.label" default="Job Title" />
		
	</label>
	<g:textField name="jobTitle" value="${person?.jobTitle}"/>
</div>

