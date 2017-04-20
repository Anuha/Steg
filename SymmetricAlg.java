package com.example.anuhachera.myapplication;

/**
 * Created by anuhachera on 25/03/2016.
 */
public class SymmetricAlg extends MainActivity {
    import java.security.SecureRandom

    import javax.crypto.Cipher
    import javax.crypto.KeyGenerator
    import javax.crypto.spec.SecretKeySpec

    import android.app.Activity
    import android.os.Bundle
    import android.util.Base64
    import android.util.Log
    import android.widget.TextView

    public class SymmetricAlgorithmAES extends MainActivityinActivity {
        static final String TAG = "SymmetricAlgorithmAES";

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.symm);

            // The original text to encyrpt
            String theTestText = "Encrypt this text!";
            TextView tv = (TextView)findViewById(R.id.tvorig);
            tv.setText("\n[ORIGINAL]:\n" + theTestText + "\n");

            // Set up secret key spec for 128-bit AES encryption and decryption
            SecretKeySpec sks = null;
            try {
                SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
                sr.setSeed("any data used as random seed".getBytes());
                KeyGenerator kg = KeyGenerator.getInstance("AES");
                kg.init(128, sr);
                sks = new SecretKeySpec((kg.generateKey()).getEncoded(), "AES");
            } catch (Exception e) {
                Log.e(TAG, "AES secret key spec error");
            }

            // Encode the original data with AES
            byte[] encodedBytes = null;
            try {
                Cipher c = Cipher.getInstance("AES");
                c.init(Cipher.ENCRYPT_MODE, sks);
                encodedBytes = c.doFinal(theTestText.getBytes());
            } catch (Exception e) {
                Log.e(TAG, "AES encryption error");
            }
            TextView tvencoded = (TextView)findViewById(R.id.tvencoded);
            tvencoded.setText("[ENCODED]:\n" +
                    Base64.encodeToString(encodedBytes, Base64.DEFAULT) + "\n");

            // Decode the encoded data with AES
            byte[] decodedBytes = null;
            try {
                Cipher c = Cipher.getInstance("AES");
                c.init(Cipher.DECRYPT_MODE, sks);
                decodedBytes = c.doFinal(encodedBytes);
            } catch (Exception e) {
                Log.e(TAG, "AES decryption error");
            }
            TextView tvdecoded = (TextView)findViewById(R.id.tvdecoded);
            tvdecoded.setText("[DECODED]:\n" + new String(decodedBytes) + "\n");
        }
    }

}
