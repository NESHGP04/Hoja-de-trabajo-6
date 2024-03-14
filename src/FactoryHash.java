
public class FactoryHash<K,V> {

    public static final int MD5_HASH = 0;
    public static final int SHA1_HASH = 1;
    public static final int ORGANICO_Hash = 2;

    public static IHash getHashMap (int formatType){
        switch(formatType) {
            case MD5_HASH: return new MD5HashMap();
            case SHA1_HASH: return new SHA1HashMap();
            case ORGANICO_Hash: return new OrganicoHashMap();
            default : return new MD5HashMap();
        }
    }    
}
