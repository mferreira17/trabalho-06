package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="automovel")
@NoArgsConstructor
public class Automovel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ano_fabricacao")
	private Integer anoFabricacao;

	@Column(name = "ano_modelo")
	private Integer anoModelo;

	@Column(name = "observacoes")
	private String observacao;

	@Column(name = "preco")
	private Float preco;

	@Column(name = "kilometragem")
	private Integer kilometragem;

	@ManyToOne
	@JoinColumn(name = "id_modelo", referencedColumnName = "id")
	private Modelo modelo;
	
	@Lob
	@Column
	private byte[] foto;
	
	

}
