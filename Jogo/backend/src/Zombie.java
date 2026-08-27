public class Zombie {

    int x;
    int y;

    int velocidade;

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
        this.velocidade = 2;
    }

    public void moverEmDirecao(int alvoX, int alvoY) {

        if (x < alvoX) {
            x += velocidade;
        }

        if (x > alvoX) {
            x -= velocidade;
        }

        if (y < alvoY) {
            y += velocidade;
        }

        if (y > alvoY) {
            y -= velocidade;
        }
    }
}