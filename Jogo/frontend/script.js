const player = document.getElementById("player");

let playerX = 100;
let playerY = 100;

const teclas = {
    w: false,
    a: false,
    s: false,
    d: false
};

document.addEventListener("keydown", function(event) {

    const tecla = event.key.toLowerCase();

    if (tecla === "w") teclas.w = true;
    if (tecla === "a") teclas.a = true;
    if (tecla === "s") teclas.s = true;
    if (tecla === "d") teclas.d = true;

});

document.addEventListener("keyup", function(event) {

    const tecla = event.key.toLowerCase();

    if (tecla === "w") teclas.w = false;
    if (tecla === "a") teclas.a = false;
    if (tecla === "s") teclas.s = false;
    if (tecla === "d") teclas.d = false;

});

function enviarComando(comando) {

    fetch("/player", {

        method: "POST",
        body: comando

    })

    .then(response => response.json())

    .then(data => {

        playerX = data.x;
        playerY = data.y;

        atualizarTela();

    })

}

function atualizarTela() {

    player.style.left = playerX + "px";
    player.style.top = playerY + "px";

}

setInterval(function() {

    if (teclas.w) enviarComando("W");
    if (teclas.a) enviarComando("A");
    if (teclas.s) enviarComando("S");
    if (teclas.d) enviarComando("D");

}, 50);

atualizarTela();