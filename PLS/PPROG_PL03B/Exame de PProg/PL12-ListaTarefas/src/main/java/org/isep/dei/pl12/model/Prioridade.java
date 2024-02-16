package org.isep.dei.pl12.model;

import java.io.Serializable;

public enum Prioridade implements Serializable {
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

}
