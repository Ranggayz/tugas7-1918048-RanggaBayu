package com.example.tugasrumah7;

public class PetShop
      { private String _id, _nama, _jenis, _asal;
        public PetShop(String id, String nama, String jenis, String asal) {
            this._id = id;
            this._nama = nama;
            this._jenis = jenis;
            this._asal = asal;
        }
        public PetShop() {
        }
        public String get_id() {
            return _id;
        }
        public void set_id(String _id) {
            this._id = _id;
        }
        public String get_nama() {
            return _nama;
        }
        public void set_nama(String _nama) {
            this._nama = _nama;
        }
        public String get_jenis() {
            return _jenis;
        }
        public void set_jenis(String _jenis) {
            this._jenis = _jenis;
        }
        public String get_asal() {

            return _asal;
        }
        public void set_asal(String _asal) {
            this._asal = _asal;
        }
}

