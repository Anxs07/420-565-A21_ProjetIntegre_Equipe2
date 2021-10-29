import React from 'react'
import {
  IonContent,
  IonHeader,
  IonIcon,
  IonItem,
  IonLabel,
  IonList,
  IonListHeader,
  IonMenu,
  IonMenuToggle,
  IonNote,
  IonTitle,
  IonToolbar,
} from '@ionic/react';
import './Menu.css'
import { useLocation } from 'react-router';

interface ComptePage {
  url: string;
  //iosIcon: string;
  //mdIcon: string;
  title: string;
}

const comptePages: ComptePage[] = [
  {
    title: 'Compte étudiant',
    url: '/authentificationPage/studentAuth',
  },
  {
    title: 'Compte superviseur',
    url: '/authentificationPage/supervisorAuth',
  },
  {
    title: 'Compte moniteur',
    url: '/authentificationPage/monitorAuth',
  },
  {
    title: 'Compte gestionnaire',
    url: '/authentificationPage/adminAuth',
  }
];

const Menu = () => {
  const location = useLocation();

  return (
    <IonMenu contentId="main" type="overlay">
      <IonContent>
        <IonList id="inbox-list">
          <IonListHeader>Comptes</IonListHeader>
          {comptePages.map((comptePage, index) => {
            return (
              <IonMenuToggle key={index} autoHide={false}>
                <IonItem className={location.pathname === comptePage.url ? 'selected' : ''} routerLink={comptePage.url} routerDirection="none" lines="none" detail={false}>
                  <IonIcon slot="start" />
                  <IonLabel>{comptePage.title}</IonLabel>
                </IonItem>
              </IonMenuToggle>
            );
          })}
        </IonList>
      </IonContent>
    </IonMenu>
  )
}

export default Menu
