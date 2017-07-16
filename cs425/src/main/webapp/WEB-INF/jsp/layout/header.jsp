 <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="/" class="navbar-brand">Attendance Report</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav nav-pills navbar-nav">
                    <li><a href="/about">About</a></li>
                    <li><a href="/contact">Contact</a></li>
				    
				    <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Student<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/student/courses">View course</a></li>
                                </ul>
                            </li>
                            
				    <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Faculty<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/faculty/courses">View course</a></li>
                                </ul>
                            </li>
                                     
                     
                     <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Staff<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/attendance/manage">Manage attendance</a></li>
                                    <li><a href="/student/find">Find student</a></li>
                                </ul>
                     </li>
                     
                     <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Administrator<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/user/find">Manage User</a></li>
                                    <li><a href="/student/find">Find student</a></li>
                                </ul>
                     </li>
				    
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
					<li><a href=""> Welcome: ${userName}</a></li>
        			<li><a href="/logout">Log out</a></li>
        		</ul>
			</div>
	 </div>
</div>
