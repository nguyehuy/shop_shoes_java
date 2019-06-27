<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<c:url value="/resources/images" var="img" />
	<c:url value="/login" var="url" />
	<!-- header -->
	<header>

		<div class="row">
			<div class="col-md-3 top-info text-left mt-lg-4">
				<h6>Need Help</h6>
				<ul>
					<li><i class="fas fa-phone"></i> Call</li>
					<li class="number-phone mt-3">12345678099</li>
				</ul>
			</div>
			<div class="col-md-6 logo-w3layouts text-center">
				<h1 class="logo-w3layouts">
					<a class="navbar-brand" href="<c:url value="/"/>"> Goggles </a>
				</h1>
			</div>

			<div class="col-md-3 top-info-cart text-right mt-lg-4">
				<ul class="cart-inner-info" style="display: ruby;">
					<li class="galssescart galssescart2 cart cart box_1"><security:authorize
							access="isAuthenticated()">
							<security:authentication property="principal" var="user" />

							
							<div class="dropdown">
								<button class=" top_googles_cart btn btn-default dropdown-toggle" type="button"
									data-toggle="dropdown" data-hover="dropdown">
									${user.username } <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li style="display:block; text-align:center "><a href="<c:url value="/infomation"/>">Infomation</a></li>
									<li style="display:block; text-align:center "><a href="<c:url value="/log-out"/>">Log Out</a></li>
								</ul>
							</div>


						</security:authorize> <security:authorize access="!isAuthenticated()">
							<li class="button-log"><a class="btn-open" href="#"> <span
									class="fa fa-user" aria-hidden="true"></span>
							</a></li>
						</security:authorize></li>
					<li class="galssescart galssescart2 cart cart box_1">
						
							<input type="hidden" name="cmd" value="_cart"> <input
								type="hidden" name="display" value="1">
							<button class="top_googles_cart" name="submit"
								value="">
								My Cart <i class="fas fa-cart-arrow-down"></i>
							</button>
						
					</li>
					<li class="galssescart galssescart2 cart cart box_1">
						<button class="top_googles_cart1"
							onclick="window.location.href = '<c:url value="/checkout"/>';">
							Check Out<i class="fas fa-cart-arrow-down"></i>
						</button>

					</li>
				</ul>
				<!---->
				<div class="overlay-login text-left">
					<button type="button" class="overlay-close1">
						<i class="fa fa-times" aria-hidden="true"></i>
					</button>
					<div class="wrap">
						<h5 class="text-center mb-4">Login Now</h5>
						<h5 class="text-center mb-4">
							<a href="<c:url value="/signup"/>">Signup</a>
						</h5>
						<div class="login p-5 bg-dark mx-auto mw-100">
							<form action="${url}" method="post">
								<div class="form-group">
									<label class="mb-2">Email address</label> <input type="text"
										class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" placeholder="" name="username"
										required=""> <small id="emailHelp"
										class="form-text text-muted">We'll never share your
										email with anyone else.</small>
									<c:if test="${error!=null }">
										<p style="color: red">Wrong username or password</p>
									</c:if>
									<c:if test="${error1!=null }">
										<p style="color: red">You have to login</p>
									</c:if>
								</div>
								<div class="form-group">
									<label class="mb-2">Password</label> <input type="password"
										class="form-control" id="exampleInputPassword1" placeholder=""
										name="password" required="">
								</div>
								<div class="form-check mb-2">
									<input type="checkbox" class="form-check-input"
										id="exampleCheck1"> <label class="form-check-label"
										for="exampleCheck1">Check me out</label>
								</div>
								<div></div>
								<button type="submit" class="btn btn-primary submit mb-4">Sign
									In</button>


							</form>

						</div>
						<!---->
					</div>
				</div>
				<!---->
			</div>
		</div>
		<div class="search">
			<div class="mobile-nav-button">
				<button id="trigger-overlay" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
			<!-- open/close -->
			<div class="overlay overlay-door">
				<button type="button" class="overlay-close">
					<i class="fa fa-times" aria-hidden="true"></i>
				</button>
				<form action="#" method="post" class="d-flex">
					<input class="form-control" type="search"
						placeholder="Search here..." required="">
					<button type="submit" class="btn btn-primary submit">
						<i class="fas fa-search"></i>
					</button>
				</form>

			</div>
			<!-- open/close -->
		</div>
		<label class="top-log mx-auto"></label>
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light top-header mb-2">

			<button class="navbar-toggler mx-auto" type="button"
				data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"> </span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav nav-mega mx-auto">
					<li class="nav-item active"><a class="nav-link ml-lg-0"
						href="<c:url value="/"/>">Home <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/about"/>">About</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Features </a>
						<ul class="dropdown-menu mega-menu ">
							<li>
								<div class="row">
									<div class="col-md-4 media-list span4 text-left">
										<h5 class="tittle-w3layouts-sub">Tittle goes here</h5>
										<ul>
											<li class="media-mini mt-3"><a
												href="<c:url value="/shop"/>">Designer Glasses</a></li>
											<li class=""><a href="<c:url value="/shop"/>">
													Ray-Ban</a></li>
											<li><a href="<c:url value="/shop"/>">Prescription
													Glasses</a></li>
											<li class="mt-3">
												<h5>View more pages</h5>
											</li>
											<li class="mt-2"><a href="<c:url value="/about"/>">About</a></li>
											<li><a href="<c:url value="/about"/>">Customers</a></li>
										</ul>
									</div>
									<div class="col-md-4 media-list span4 text-left">
										<h5 class="tittle-w3layouts-sub">Tittle goes here</h5>
										<div class="media-mini mt-3">
											<a href="<c:url value="/shop"/>"> <img
												src="${img}/g2.jpg" class="img-fluid" alt="">
											</a>
										</div>
									</div>
									<div class="col-md-4 media-list span4 text-left">
										<h5 class="tittle-w3layouts-sub">Tittle goes here</h5>
										<div class="media-mini mt-3">
											<a href="<c:url value="/shop"/>"> <img
												src="${img}/g3.jpg" class="img-fluid" alt="">
											</a>
										</div>

									</div>
								</div>
								<hr>
							</li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown1"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Shop </a>
						<ul class="dropdown-menu mega-menu ">
							<li>
								<div class="row">
									<div class="col-md-4 media-list span4 text-left">
										<h5 class="tittle-w3layouts-sub">Tittle goes here</h5>
										<ul>
											<li class="media-mini mt-3"><a
												href="<c:url value="/shop/Designer Glasses"/>">Designer
													Glasses</a></li>
											<li class=""><a href="<c:url value="/shop/Ray-Ban"/>">
													Ray-Ban</a></li>
											<li><a
												href="<c:url value="/shop/Prescription Glasses"/>">Prescription
													Glasses</a></li>
											<li><a href="<c:url value="/shop/Rx Sunglasses"/>">Rx
													Sunglasses</a></li>
											<li><a href="<c:url value="/shop/Contact Lenses"/>">Contact
													Lenses</a></li>
											<li><a href="<c:url value="/shop/Multifocal Glasses"/>">Multifocal
													Glasses</a></li>
											<li><a href="<c:url value="/shop/Kids Glasses"/>">Kids
													Glasses</a></li>
											<li><a href="<c:url value="/shop/Lightweight Glasses"/>">Lightweight
													Glasses</a></li>
											<li><a href="<c:url value="/shop/Sports Glasses"/>">Sports
													Glasses</a></li>
										</ul>
									</div>
									<div class="col-md-4 media-list span4 text-left">
										<h5 class="tittle-w3layouts-sub">Tittle goes here</h5>
										<ul>
											<li class="media-mini mt-3"><a
												href="<c:url value="/shop"/>">Brooks Brothers</a></li>
											<li><a href="<c:url value="/shop"/>">Persol</a></li>
											<li><a href="<c:url value="/shop"/>">Polo Ralph
													Lauren</a></li>
											<li><a href="<c:url value="/shop"/>">Prada</a></li>
											<li><a href="<c:url value="/shop"/>">Ray-Ban Jr</a></li>
											<li><a href="<c:url value="/shop"/>">Sferoflex</a></li>
										</ul>
										<ul class="sub-in text-left">

											<li><a href="<c:url value="/shop"/>">Polo Ralph
													Lauren</a></li>
											<li><a href="<c:url value="/shop"/>">Prada</a></li>
											<li><a href="<c:url value="/shop"/>">Ray-Ban Jr</a></li>
										</ul>

									</div>
									<div class="col-md-4 media-list span4 text-left">

										<h5 class="tittle-w3layouts-sub-nav">Tittle goes here</h5>
										<div class="media-mini mt-3">
											<a href="<c:url value="/shop"/>"> <img
												src="${img}/g1.jpg" class="img-fluid" alt="">
											</a>
										</div>

									</div>
								</div>
								<hr>
							</li>
						</ul></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/contact"/>">Contact</a></li>
				</ul>

			</div>
		</nav>
	</header>
</body>
</html>