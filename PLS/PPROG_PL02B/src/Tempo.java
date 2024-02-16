public class Tempo {
    public static final int DEFAULT_TIME = 0;
    private int hora;
    private int minuto;
    private int segundo;
    private String ampm;
    private static final int AFTERNOON_TIME = 12;
    private static final String FORMATADO = "nulo";

    public Tempo(){
        hora=DEFAULT_TIME;
        minuto=DEFAULT_TIME;
        segundo=DEFAULT_TIME;
        ampm = FORMATADO;
    }
    public Tempo(int hora, int minuto, int segundo){
        this.hora=hora;
        this.minuto=minuto;
        this.segundo=segundo;
    }
    public void TempoFormatado(int hora, int minuto, int segundo, String ampm){
        this.hora=hora;
        this.minuto=minuto;
        this.segundo=segundo;
        this.ampm = ampm;
    }
    public String getAmpm(){
        return ampm;
    }
    public int getHora() {

        return hora;
    }
    public int getMinuto() {

        return minuto;
    }
    public int getSegundo() {

        return segundo;
    }
    public void setAmpm(String ampm){
        this.ampm = ampm;
    }
    public void setHora(int hora) {
        this.hora = hora;
    }
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }
    public String getTime(){
        return hora + ":" + minuto + ":" + segundo;
    }

    public void adicionarSegundo(){
        this.segundo += 1;
        if(this.segundo >= 60){
            this.segundo = 0;
            this.minuto += 1;
            if(this.minuto >= 60){
                this.minuto = 0;
                this.hora +=1;
            }
        }
    }

    public Tempo compararTemposNormal(Tempo temp1){

    if (this.hora > temp1.hora){
        return this;
    }else if(this.hora < temp1.hora){
        return temp1;
    }else if (this.hora == temp1.hora){
        if (this.minuto > temp1.minuto){
            return this;
        }else if (this.minuto < temp1.minuto){
            return temp1;
        }else if (this.minuto == temp1.minuto){
            if(this.segundo > temp1.segundo){
                return this;
            }else if(this.segundo < temp1.segundo){
                return temp1;
            }
        }
    }

    return null;
    }

    public Tempo compararTemposFormatado(Tempo temp1){
        if(this.ampm == temp1.ampm){
        if (this.hora > temp1.hora){
            return this;
        }else if(this.hora < temp1.hora){
            return temp1;
        }else if (this.hora == temp1.hora){
            if (this.minuto > temp1.minuto){
                return this;
            }else if (this.minuto < temp1.minuto){
                return temp1;
            }else if (this.minuto == temp1.minuto){
                if(this.segundo > temp1.segundo){
                    return this;
                }else if(this.segundo < temp1.segundo){
                    return temp1;
                }
            }
        }
        }else if (this.ampm == "AM" && temp1.ampm == "PM"){
            return temp1;
        }else if (this.ampm == "PM" && temp1.ampm == "AM"){
            return this;
        }

        return null;
    }
    public int diferencaTemposSegundos(Tempo temp1){
        int tempObject2 = temp1.hora*3600 + temp1.minuto*60 +temp1.segundo;
        int tempObject1 = this.hora*3600 + this.minuto*60 + this.segundo;

        return tempObject2 - tempObject1;
    }
    public Tempo diferencaTempo(Tempo temp1){

       int diferenca = this.diferencaTemposSegundos(temp1);
        Tempo tempaux = new Tempo();

        tempaux.hora = diferenca / 3600;
        tempaux.minuto = (diferenca % 3600) / 60;
        tempaux.segundo = diferenca % 60;

        return tempaux;
    }

    @Override

    public String toString(){
        if (hora>=AFTERNOON_TIME) {
            hora -= 12;
            return hora  + ":" + minuto + ":" + segundo + "PM";
        }
        else
            return hora + ":" + minuto + ":" + segundo + "AM";
    }


}
