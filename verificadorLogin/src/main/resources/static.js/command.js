document.addEventListener('DOMContentLoaded', function () {
  const cadastrar = document.getElementById("cadastrar");
  const entrar = document.getElementById("entrar");
  const container = document.querySelector(".container");
  const esqueceuSenha = document.querySelectorAll(".esqueceuSenha");

    cadastrar.addEventListener("click", () => {
        container.classList.add("painel-direito-ativo");
    });

    esqueceuSenha.forEach(link => {
        link.addEventListener("click", () => {
            container.classList.add("painel-direito-ativo");
        });
    });

    entrar.addEventListener("click", () => {
        container.classList.remove("painel-direito-ativo");
    });

});