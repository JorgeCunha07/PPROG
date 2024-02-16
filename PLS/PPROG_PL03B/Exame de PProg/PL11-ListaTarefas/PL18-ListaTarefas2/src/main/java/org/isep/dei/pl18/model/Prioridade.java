package org.isep.dei.pl18.model;

public enum Prioridade {
    BAIXA {
        public String toString() {
            return "Baixa";
        }
    },
    ABAIXO_NORMAL {
        public String toString() {
            return "Abaixo do Normal";
        }
    },
    NORMAL {
        public String toString() {
            return "Normal";
        }
    },
    ACIMA_NORMAL {
        public String toString() {
            return "Acima do Normal";
        }
    },
    ELEVADO {
        public String toString() {
            return "Elevado";
        }
    },
    TEMPO_REAL {
        public String toString() {
            return "Tempo Real";
        }
    };
    
//    LOW {
//        public String toString() {
//            return "LOW";
//        }
//    },
//    BELLOW_NORMAL {
//        public String toString() {
//            return "Bellow Normal";
//        }
//    },
//    NORMAL {
//        public String toString() {
//            return "Normal";
//        }
//    },
//    ABOVE_NORMAL {
//        public String toString() {
//            return "Above Normal";
//        }
//    },
//    HIGH {
//        public String toString() {
//            return "High";
//        }
//    },
//    REALTIME {
//        public String toString() {
//            return "Realtime";
//        }
//    };
}


