<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>
<div class="main-header">
	<nav class="navbar navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a href="Index.html" class="navbar-brand"></a>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse pull-left" id="navbar-collapse">
				<ul class="nav navbar-nav">

					<c:forEach items="${menuList}" var="amenu">
						<c:if test="${amenu.hasSubMenu}">

							<c:if test="${amenu.active}">
								<li class="dropdown active">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">${amenu.name}<span class="caret"></span></a>
									<ul class="dropdown-menu" role="menu">
										<c:forEach items="${amenu.childs}" var="subMenu">
											<li><a href="${ctx}/publicity/${subMenu.url}">${subMenu.name}</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>

							<c:if test="${!amenu.active}">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">${amenu.name}<span class="caret"></span></a>
									<ul class="dropdown-menu" role="menu">
										<c:forEach items="${amenu.childs}" var="subMenu">
											<li><a href="${ctx}/publicity/${subMenu.url}">${subMenu.name}</a></li>
										</c:forEach>
									</ul></li>
							</c:if>

						</c:if>

						<c:if test="${!amenu.hasSubMenu}">
							<c:if test="${amenu.active}">
								<li class="active"><a href="${ctx}/publicity/${amenu.url}">${amenu.name}</a></li>
							</c:if>
							<c:if test="${amenu.active == false}">
								<li><a href="${ctx}/publicity/${amenu.url}">${amenu.name}</a></li>
							</c:if>
						</c:if>
					</c:forEach>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
			<!-- Navbar Right Menu -->

		</div>
		<!-- /.container-fluid -->
	</nav>
</div>