import Logo from '../../assets/img/logo.svg';
import './styles.css';
const Header = () => {
  return (
    <header>
      <div className="dsmeta-logo-container">
        <img src={Logo} alt="DSMeta" />
        <h1>DSMeta</h1>
        <p>
          Desenvolvido por
          <a
            style={{ marginLeft: '5px' }}
            href="https://www.linkedin.com/in/julio-moraes-1291a2170/"
            target="_blank"
          >
            Julio Moraes
          </a>
        </p>
      </div>
    </header>
  );
};

export default Header;
