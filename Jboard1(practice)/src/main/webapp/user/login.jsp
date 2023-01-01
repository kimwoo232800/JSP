<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String success = request.getParameter("success");
%>
<%@ include file="./_header.jsp" %>
<script>
	let success = "<%= success %>";
	
	if(success == "100") {
		// 회원이 아닐 경우
		alert('일치하는 회원이 없습니다.\n아이디, 비밀번호를 다시 확인 하십시오.');
	}else{
		// 다른 경우
		alert('먼저 로그인을 하셔야 합니다.');
	}
</script>

</script>
        <main id="user">
            <section class="login">
                <form action="/Jboard1.1/user/proc/loginProc.jsp">
                    <table border="0">
                        <tr>
                            <td><img src="../img/login_ico_id.png" alt="아이디"/></td>
                            <td><input type="text" name="uid" placeholder="아이디 입력"/></td>
                        </tr>
                        <tr>
                            <td><img src="../img/login_ico_pw.png" alt="비밀번호"/></td>
                            <td><input type="password" name="pass" placeholder="비밀번호 입력"/></td>
                        </tr>
                    </table>
                    <input type="submit" value="로그인" class="btnLogin"/>
                </form>
                <div>
                    <h3>회원 로그인 안내</h3>
                    <p>
                        아직 회원이 아니시면 회원으로 가입하세요.
                    </p>
                    <a href="./terms.jsp">회원가입</a>
                </div>
            </section>
        </main>
        <%@ include file="./_footer.jsp" %>