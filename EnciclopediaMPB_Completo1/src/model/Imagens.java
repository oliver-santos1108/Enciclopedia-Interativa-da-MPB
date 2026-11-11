package model;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class Imagens {
    public static final int LADO_MAXIMO = 600;
    private Imagens() { }

    public static byte[] lerReduzida(File arquivo) throws IOException {
        BufferedImage original = ImageIO.read(arquivo);
        if (original == null)
            throw new IOException("Formato de imagem não suportado: " + arquivo.getName());
        return paraJpeg(reduzir(original, LADO_MAXIMO));
    }

    public static BufferedImage reduzir(BufferedImage origem, int ladoMaximo) {
        int largura = origem.getWidth();
        int altura = origem.getHeight();
        if (largura <= ladoMaximo && altura <= ladoMaximo) return origem;

        double escala = (largura >= altura)
            ? (double) ladoMaximo / largura : (double) ladoMaximo / altura;
        int novaLargura = Math.max(1, (int) Math.round(largura * escala));
        int novaAltura = Math.max(1, (int) Math.round(altura * escala));
        BufferedImage destino = new BufferedImage(novaLargura, novaAltura, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = destino.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                           RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(origem, 0, 0, novaLargura, novaAltura, null);
        g.dispose();
        return destino;
    }

    public static byte[] paraJpeg(BufferedImage imagem) throws IOException {
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        ImageIO.write(imagem, "jpg", saida);
        return saida.toByteArray();
    }

    public static BufferedImage deBytes(byte[] dados) throws IOException {
        if (dados == null || dados.length == 0) return null;
        return ImageIO.read(new ByteArrayInputStream(dados));
    }
}
