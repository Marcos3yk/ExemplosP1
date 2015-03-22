package cadastro;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/alucontroller", "/AlunoServlet", "/AlunoController", "/AlunoController.do" })
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//String acao = req.getParameter("acao");
		//System.out.println(acao);
		GerenciadorAluno ga = new GerenciadorAluno();
		
		//if (acao.equals("alu")) {
			// Pegar a lista
			
			List<Aluno> alunos = ga.getAlunos();

			// Adiciona a lista no request como atributo

			req.setAttribute("alu", alunos);

			// Levar para o JSP
			RequestDispatcher view = req.getRequestDispatcher("alunos.jsp");
			view.forward(req, resp);
		//} else if (acao.equals("exc")){
			//String pos =  req.getParameter("pos");
			//ga.excluir(Integer.parseInt(pos));
			//resp.getWriter()
			//.print("<script> window.alert('Excluido Sucesso!'); location.href='AlunoController?acao=lis'; </script>");

			
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String estado = request.getParameter("estado");
		String sexo = request.getParameter("sexo");	
				
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setRg(rg);
		aluno.setEstado(estado);
		aluno.setSexo(sexo);
	

		GerenciadorAluno ga = new GerenciadorAluno();
		ga.salvar(aluno);
		response.setContentType("text/html");
		response.getWriter()
				.print("<script> window.alert('Salvo Sucesso!'); location.href='AlunoController'; </script>");

	}

}
