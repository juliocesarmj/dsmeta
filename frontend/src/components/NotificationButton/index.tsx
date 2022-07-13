import NotificationIcon from '../../assets/img/notification-icon.svg';
import './styles.css';
const NotificationButton = () => {
  return (
    <div className="dsmeta-red-btn">
      <img src={NotificationIcon} alt="Notificar" />
    </div>
  );
};
export default NotificationButton;
