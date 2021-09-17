import React from 'react';
import PropTypes from 'prop-types';
import styles from './Moniteur.module.css';

const Moniteur = () => {
  return (
    <div className={styles.Moniteur}>
      Moniteur Component
      <h1>Formulaire</h1>
      {/* <form onSubmit={}> */}
      <div className="mx-auto">
        <form className="col-md-6">
          <div class="form-group">
            <label>Nom:</label>
            <input type="text" className="form-control" placeholder="Nom"/>
          </div>
          <div class="form-group">
            <label>Prénom:</label>
            <input type="text" className="form-control" placeholder="Prénom"/>
          </div>
          <div class="form-group">
            <label>Mot de Passe:</label>
            <input type="password" className="form-control" placeholder="Mot de Passe" />
          </div>
          <div class="form-group">
            <label>Nom de l'entreprise:</label>
            <input type="text" className="form-control" placeholder="Nom de l'entreprise"/>
          </div>
          <div class="form-group">
            <label>Courriel:</label>
            <input type="email" className="form-control" placeholder="Courriel"/>
          </div>
          <input type="submit" value="Submit" />
        </form>
      </div>

    </div>
  )
}

Moniteur.propTypes = {};

Moniteur.defaultProps = {};

export default Moniteur;
