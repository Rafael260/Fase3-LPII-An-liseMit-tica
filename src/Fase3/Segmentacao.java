package Fase3;

import br.ufrn.imd.lp2.imagesegmentation.ImageInformation;
import br.ufrn.imd.lp2.imagesegmentation.ImageSegmentation;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

/** Realizar o processo de segmentação de uma determinada imagem.
 *  pode-se gerar mapa de rótulos, segmentar imagem, contar o número de regiões
 * @author EliseuMedeiros;RafaelOliveira
 * @version 13/11/2015 - 11:55
 */
public class Segmentacao {
    private ImageInformation imagem;
    private String endereco;
    private boolean segmentada;
    
    private double blur_Level;
    private double color_Radius;
    private double min_Size;
    
    private final static double DEFAULT_BLUR_LEVEL = 0.5;
    private final static double DEFAULT_COLOR_RADIUS = 50.0;
    private final static double DEFAULT_MIN_SIZE = 100.0;
    
    //Adicionar novos tipos de imagem caso puder
    private final String[] extensoesImagem = { ".jpg", ".JPG", ".png"};
     
    /**construtor da classe Segmentacao.  
     */
    public Segmentacao(){
        imagem = null;
        endereco = null;
        segmentada = false;
    }
    /**Sobrecarga do construtor da classe Segmentacao. 
     * recebe o endereço da imagem.
     * @param endereco
     */
    public Segmentacao(String endereco){
        imagem = null;
        this.endereco = endereco;
        segmentada = false;
    }
    /**retornar imagem.
     * @return ImageInformation  
     */
    public ImageInformation getImagem() {
        return imagem;
    }
    /**setar imagem.
     * @param imagem
     */
    public void setImagem(ImageInformation imagem) {
        this.imagem = imagem;
    }

    public double getBlur_Level() {
        return blur_Level;
    }

    public void setBlur_Level(double blur_Level) {
        this.blur_Level = blur_Level;
    }

    public double getColor_Radius() {
        return color_Radius;
    }

    public void setColor_Radius(double color_Radius) {
        this.color_Radius = color_Radius;
    }

    public double getMin_Size() {
        return min_Size;
    }

    public void setMin_Size(double min_Size) {
        this.min_Size = min_Size;
    }

    public static double getDefaultBlurLevel() {
        return DEFAULT_BLUR_LEVEL;
    }

    public static double getDefaultColorRadius() {
        return DEFAULT_COLOR_RADIUS;
    }

    public static double getDefaultMinSize() {
        return DEFAULT_MIN_SIZE;
    }
    
    public String getNomeArquivo(){
        File f = new File(endereco);
        String nome = f.getName();
        return nome.replace(".jpg", "");
        //String [] partesNome = nome.split(".");
        //return partesNome[0];
    }
    
    public int getIndiceDeVetor(int x, int y){
        return y*imagem.getWidth()+ x;
    }
    /**Retonar o endereço da imagem.
     * @return endereco
     */
    public String getEndereco() {
        return endereco;
    }
    
    //Testa se o arquivo escolhido é mesmo uma imagem
    public boolean ehImagem(String endereco){
        for (String extensao : extensoesImagem) {
            if (endereco.endsWith(extensao)) {
                return true;
            }
        }
        return false;
    }
    
    /**setar endereço de imagem.
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    /**Segmentar a imagem utilizando os atributos BLUR_LEVEL, COLOR_RADIUS E MIN_SIZE.
     */
    public void segmentarImagem(){
        imagem = ImageSegmentation.performSegmentation(endereco, blur_Level, color_Radius, min_Size);
        segmentada = true;
    }
    
    /**
     * Verifica se os parâmetros usados para o programa foram alterados desde a última segmentação
     * @param blurLevel
     * @param colorRadius
     * @param minSize
     * @return true se alterou, false caso contrário
     * TENTAR PASSAR MÉTODO E ATRIBUTOS RELACIONADOS PARA A CLASSE SEGMENTAÇÃO
     */
    public boolean estaModificado(double blurLevel, double colorRadius, double minSize){
        if (blurLevel != blur_Level || colorRadius != color_Radius || minSize != min_Size){
            //Atualiza os novos valores de parâmetro.
            blur_Level = blurLevel;
            color_Radius = colorRadius;
            min_Size = minSize;
            return true;
        }
        else{
            return false;
        }
    }
    
    /**Retornar região da imagem segmentada.
     * @return imagem.getRegionMarkedImage()
     */
    public BufferedImage getImagemSegmentada(){
        return imagem.getRegionMarkedImage();
    }
    
    public BufferedImage getImagemOriginal(){
        return imagem.getOriginalImage();
    }
    
    /**Retornar o número de regiões detectadas.
     * @return imagem.getTotalRegions()
     */
    public int getNumeroDeRegioes(){
        return imagem.getTotalRegions();
    }
    
    public int[] getMapaDeRegioes(){
        return imagem.getSegmentedImageMap();
    }
    /**Retornar o mapa de rótulo da imagem segmentada.
     * @return imagemAuxiliar
     */
    public BufferedImage getImagemMapaRotulo(){
        BufferedImage imagemAuxiliar = imagem.getOriginalImage();

        Color[] cinza = new Color[imagem.getTotalRegions()];
        int novoCinza;
        for(int i = 0; i < cinza.length; i++){
            novoCinza = (i*15)%255; //gerando escala de cinza
            cinza[i] = new Color(novoCinza, novoCinza, novoCinza);
        }     

        int[] pixelsSegmentada = imagem.getSegmentedImageMap();
        //laços para aplicar a escala de cinza na criação do mapa de rótulos
        for(int i = 0, cont = 0; i < imagemAuxiliar.getHeight(); i++){
            for(int j = 0; j < imagemAuxiliar.getWidth(); j++){
                imagemAuxiliar.setRGB(j,i,cinza[pixelsSegmentada[cont++]].getRGB());
            }
        }
        return imagemAuxiliar;
    }
    
    public boolean estaSegmentada(){
        return segmentada;
    }
    
    public boolean estaNoIntervalo(int x, int y){
        return y < imagem.getHeight() && x < imagem.getWidth();
    }
    
    /**
     * Retorna o mapa de pixels da imagem segmentada - Verifica se ta nula?
     * @return 
     */
    public int[] getMapaPixelsSeg(){
        return imagem.getSegmentedImageMap();
    }
    /**
     * Resetar (setar com null) os parâmetros de Imagem e Endereço.
     */
    public void resetaImagem(){
        imagem = null;
        endereco = null;
        segmentada = false;
    }
}
