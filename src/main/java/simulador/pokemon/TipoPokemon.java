package simulador.pokemon;

public enum TipoPokemon {
    NORMAL, FUEGO, AGUA, ELECTRICO, PLANTA, VENENO, PSIQUICO,
    ROCA, TIERRA, VOLADOR, HADA, LUCHA, ACERO, BICHO, HIELO, FANTASMA, BICHO_PLANTA, NORMAL_VOLADOR;

    public double calcularVentaja(TipoPokemon otro) {
        switch (this) {
            case FUEGO:
                if (otro == PLANTA || otro == HIELO || otro == BICHO ) return 2.0;
                if (otro == AGUA || otro == ACERO || otro == ROCA) return 0.5;
                break;
            case AGUA:
                if (otro == FUEGO || otro == ROCA) return 2.0;
                if (otro == PLANTA) return 0.5;
                break;
            case PLANTA:
                if (otro == AGUA || otro == ROCA || otro == TIERRA ) return 2.0;
                if (otro == FUEGO || otro == VENENO || otro == BICHO || otro == ACERO) return 0.5;
                break; 
            case VENENO:
                if (otro == PLANTA || otro == HADA) return 2.0;
                if (otro == ROCA || otro == FANTASMA) return 0.5;
                break;
            case ELECTRICO:
                if (otro == AGUA || otro == VOLADOR) return 2.0;
                if (otro == PLANTA) return 0.5;
                if (otro == TIERRA) return 0;
                break;
            case PSIQUICO:
                if (otro == VENENO || otro == LUCHA) return 2.0;
                break;
            case ROCA:
                if (otro == FUEGO || otro == VOLADOR || otro == ACERO || otro == BICHO || otro == HIELO) return 2.0;
                if (otro == LUCHA) return 0.5;
                break;
            case TIERRA:
                if (otro == FUEGO || otro == VENENO || otro == ROCA || otro == ACERO) return 2.0;
                if (otro == VOLADOR) return 0.5;
                break;
            case NORMAL:
                if (otro == FANTASMA) return 0;
                break;
            case VOLADOR:
                if (otro == PLANTA || otro == ELECTRICO || otro == BICHO) return 2.0;
                if (otro == ROCA) return 0.5;
                break;
                case HADA:
                if (otro == PSIQUICO) return 2.0;
                break;
            case LUCHA:
                if (otro == ROCA || otro == NORMAL || otro == HIELO) return 2.0;
                if (otro == FANTASMA) return 0.5;
                break;
            case ACERO:
                if (otro == FUEGO || otro == ROCA || otro == HADA || otro == LUCHA) return 2.0;
                if (otro == PSIQUICO) return 0.5;
                break;
            case BICHO:
                if (otro == PLANTA || otro == VOLADOR) return 2.0;
                if (otro == ACERO || otro == FANTASMA) return 0.5;
                break;
            case HIELO:
                if (otro == PLANTA || otro == HIELO) return 2.0;
                break;
            case FANTASMA:
                if (otro == FANTASMA) return 2.0;
                if (otro == VENENO) return 0.5;
                if (otro == NORMAL) return 0;
                break;   
                case BICHO_PLANTA:
                if (otro == AGUA || otro == PLANTA || otro == TIERRA) return 2.0;
                if (otro == FUEGO || otro == VOLADOR) return 0.5;
                break;
                case NORMAL_VOLADOR:
                if (otro == ELECTRICO || otro == ROCA) return 2.0;
                if (otro == LUCHA || otro == TIERRA) return 0.5;
                break;
            default:
                return 1.0;
        }
        return 1.0;
    }
}
